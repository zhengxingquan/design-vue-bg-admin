package com.quan.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.core.constant.uid.IUidGenerator;
import com.quan.core.constant.web.PageResult;
import com.quan.core.dao.GatewayRoutesDao;
import com.quan.core.dto.GatewayFilterDefinition;
import com.quan.core.dto.GatewayPredicateDefinition;
import com.quan.core.dto.GatewayRouteDefinition;
import com.quan.core.model.GatewayRoutes;
import com.quan.core.service.DynamicRouteService;
import com.quan.core.vo.GatewayRoutesVO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.*;

import static com.quan.core.routes.RedisRouteDefinitionRepository.GATEWAY_ROUTES_PREFIX;


@Service
@SuppressWarnings("all")
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware, DynamicRouteService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;

    @Autowired
    private IUidGenerator uidGenerator;

    @Autowired
    private GatewayRoutesDao gatewayRoutesDao;

    private ApplicationEventPublisher publisher;

    /**
     * 初始化 转化对象
     */
    private static MapperFacade routeDefinitionMapper;
    private static MapperFacade routeVOMapper;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(GatewayRouteDefinition.class, GatewayRoutes.class)
                .exclude("filters")
                .exclude("predicates")
                .byDefault();
        routeDefinitionMapper = mapperFactory.getMapperFacade();
        //  routeVOMapper
        mapperFactory.classMap(GatewayRoutes.class, GatewayRoutesVO.class).byDefault();
        routeVOMapper = mapperFactory.getMapperFacade();

    }


    /**
     * 给spring注册事件
     * 刷新路由
     */
    private void notifyChanged() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    /**
     * Set the ApplicationEventPublisher that this object runs in.
     * <p>Invoked after population of normal bean properties but before an init
     * callback like InitializingBean's afterPropertiesSet or a custom init-method.
     * Invoked before ApplicationContextAware's setApplicationContext.
     *
     * @param applicationEventPublisher event publisher to be used by this object
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    /**
     * 新增路由
     *
     * @param gatewayRouteDefinition
     * @return
     */
    @Override
    public Long add(GatewayRouteDefinition gatewayRouteDefinition) {
        GatewayRoutes gatewayRoutes = transformToGatewayRoutes(gatewayRouteDefinition);
        gatewayRoutes.setCreateTime(new Date());
        gatewayRoutes.setUpdateTime(new Date());
        gatewayRoutesDao.insertSelective(gatewayRoutes);
        gatewayRouteDefinition.setId(gatewayRoutes.getId());
        stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).put(gatewayRouteDefinition.getId(), JSONObject.toJSONString(gatewayRouteDefinition));
        return gatewayRoutes.getId();
    }

    /**
     * 修改路由
     *
     * @param gatewayRouteDefinition
     * @return
     */
    @Override
    public Long update(GatewayRouteDefinition gatewayRouteDefinition) {
        GatewayRoutes gatewayRoutes = transformToGatewayRoutes(gatewayRouteDefinition);
        gatewayRoutes.setCreateTime(new Date());
        gatewayRoutes.setUpdateTime(new Date());
        gatewayRoutesDao.updateByPrimaryKeySelective(gatewayRoutes);
        stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).delete(gatewayRouteDefinition.getId());
        stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).put(gatewayRouteDefinition.getId(), JSONObject.toJSONString(gatewayRouteDefinition));
        return gatewayRouteDefinition.getId();
    }


    /**
     * 删除路由
     *
     * @param id
     * @return
     */
    @Override
    public String delete(String id) {
        gatewayRoutesDao.deleteByPrimaryKey(id);
        stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).delete(id);

        return "success";
//        try {
//            this.routeDefinitionWriter.delete(Mono.just(id));
//            notifyChanged();
//            return "delete success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "delete fail";
//        }
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @Override
    public PageResult<GatewayRoutesVO> findAll(Map<String, Object> params) {
        PageHelper.startPage(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"), true);
        List<GatewayRoutes> alls = gatewayRoutesDao.findAll(new HashMap());
        PageInfo<GatewayRoutesVO> pageInfo = new PageInfo<>(routeVOMapper.mapAsList(alls, GatewayRoutesVO.class));
        return PageResult.<GatewayRoutesVO>builder().data(pageInfo.getList()).code(0).count(pageInfo.getTotal()).build();
    }

    /**
     * @return
     */
    @Override
    public String synchronization() {
        HashMap map = new HashMap();
        map.put("delFlag", 0);
        List<GatewayRoutes> gatewayRoutes = gatewayRoutesDao.findAll(map);
        for (GatewayRoutes route : gatewayRoutes) {
            GatewayRouteDefinition gatewayRouteDefinition = GatewayRouteDefinition.builder()
                    .description(route.getDescription())
                    .id(route.getId())
                    .order(route.getOrder())
                    .uri(route.getUri())
                    .build();
            List<GatewayFilterDefinition> gatewayFilterDefinitions = JSONArray.parseArray(route.getFilters(), GatewayFilterDefinition.class);
            List<GatewayPredicateDefinition> gatewayPredicateDefinitions = JSONArray.parseArray(route.getPredicates(), GatewayPredicateDefinition.class);
            gatewayRouteDefinition.setPredicates(gatewayPredicateDefinitions);
            gatewayRouteDefinition.setFilters(gatewayFilterDefinitions);
            stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).put(route.getId(), JSONObject.toJSONString(gatewayRouteDefinition));


        }

        return "success";
    }

    /**
     * 更改路由状态
     *
     * @param params
     * @return
     */
    @Override
    public String updateFlag(Map<String, Object> params) {
        String id = MapUtils.getString(params, "id");
        Integer flag = MapUtils.getInteger(params, "flag");
        GatewayRoutes gatewayRoutes = gatewayRoutesDao.selectByPrimaryKey(id);
        if (gatewayRoutes == null) {
            return "route is empty";
        }

        if (flag == 1) {
            stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).delete(id);
        } else {
            GatewayRouteDefinition gatewayRouteDefinition = GatewayRouteDefinition.builder()
                    .description(gatewayRoutes.getDescription())
                    .id(gatewayRoutes.getId())
                    .order(gatewayRoutes.getOrder())
                    .uri(gatewayRoutes.getUri())
                    .build();
            List<GatewayFilterDefinition> gatewayFilterDefinitions = JSONArray.parseArray(gatewayRoutes.getFilters(), GatewayFilterDefinition.class);
            List<GatewayPredicateDefinition> gatewayPredicateDefinitions = JSONArray.parseArray(gatewayRoutes.getPredicates(), GatewayPredicateDefinition.class);
            gatewayRouteDefinition.setPredicates(gatewayPredicateDefinitions);
            gatewayRouteDefinition.setFilters(gatewayFilterDefinitions);
            stringRedisTemplate.boundHashOps(GATEWAY_ROUTES_PREFIX).put(gatewayRoutes.getId(), JSONObject.toJSONString(gatewayRouteDefinition));
        }

//        gatewayRoutes.setDataState(DataEntityState.ENABLE.getValue());
        gatewayRoutes.setUpdateTime(new Date());
        int success = gatewayRoutesDao.updateByPrimaryKeySelective(gatewayRoutes);
        return success > 0 ? "更新成功" : "更新失败";
    }

    /**
     * 转化路由对象  GatewayRoutes
     *
     * @param gatewayRouteDefinition
     * @return
     */
    private GatewayRoutes transformToGatewayRoutes(GatewayRouteDefinition gatewayRouteDefinition) {
        GatewayRoutes definition = new GatewayRoutes();
        routeDefinitionMapper.map(gatewayRouteDefinition, definition);
        //设置路由id
        if (!Objects.isNull(definition.getId())) {
            definition.setId(uidGenerator.uid());
        }
        String filters = JSONArray.toJSONString(gatewayRouteDefinition.getFilters());
        String predicates = JSONArray.toJSONString(gatewayRouteDefinition.getPredicates());
        definition.setFilters(filters);
        definition.setPredicates(predicates);

        return definition;
    }

    /**
     * 测试方法 新建 一个路由
     */
//    @PostConstruct
    public void main() {
        RouteDefinition definition = new RouteDefinition();
        definition.setId("jd");
        URI uri = UriComponentsBuilder.fromUriString("lb://user-center").build().toUri();
//         URI uri = UriComponentsBuilder.fromHttpUrl("http://baidu.com").build().toUri();
        definition.setUri(uri);
        definition.setOrder(11111);

        //定义第一个断言
        PredicateDefinition predicate = new PredicateDefinition();
        predicate.setName("Path");

        Map<String, String> predicateParams = new HashMap<>(8);
        predicateParams.put("pattern", "/jd/**");
        predicate.setArgs(predicateParams);
        //定义Filter
        FilterDefinition filter = new FilterDefinition();
        filter.setName("StripPrefix");
        Map<String, String> filterParams = new HashMap<>(8);
        //该_genkey_前缀是固定的，见org.springframework.cloud.gateway.support.NameUtils类
        filterParams.put("_genkey_0", "1");
        filter.setArgs(filterParams);

        definition.setFilters(Arrays.asList(filter));
        definition.setPredicates(Arrays.asList(predicate));

        System.out.println("definition:" + JSON.toJSONString(definition));
        stringRedisTemplate.opsForHash().put(GATEWAY_ROUTES_PREFIX, "key", JSON.toJSONString(definition));
    }
}
