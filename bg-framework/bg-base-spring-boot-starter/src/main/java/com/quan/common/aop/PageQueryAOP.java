package com.quan.common.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.common.annotation.PageQuery;
import com.quan.common.request.RequestPage;
import com.quan.common.web.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 * <p>
 * //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
 * PageHelper.startPage(MapUtils.getInteger(map, "page"), MapUtils.getInteger(map, "limit"), true);
 * <p>
 * List list = sysGeneratorDao.queryList(map);
 * <p>
 * PageInfo pageInfo = new PageInfo<>(list);
 * return PageResult.builder().data(pageInfo.getList()).code(0).count(pageInfo.getTotal()).build();
 */
@Slf4j
@Component
@Aspect
@Order(-3) // 保证该AOP在@Transactional之前执行
public class PageQueryAOP {

    @Around("@annotation(query)")
    public Object exec(ProceedingJoinPoint joinPoint, PageQuery query) throws Throwable {
        log.info("设置分页信息");
        // 判断是否 有 分页的信息
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 参数值
        RequestPage page = getPageParam(joinPoint.getArgs());
        if (page != null) {
            PageQuery pageQuery = methodSignature.getMethod().getDeclaredAnnotation(PageQuery.class);
            log.info("设置分页信息 pageNumber：{} -> pageSize：{}", page.getPageNumber(), page.getPageSize());
            PageHelper.startPage(page.getPageNumber(), page.getPageSize(), pageQuery.countState());
        }
        // 调用原来的方法
        Object result = joinPoint.proceed();
        PageInfo pageInfo = new PageInfo<>((List<? extends Object>) result);
        return PageResult.builder()
                .data(pageInfo.getList())
                .code(0)
                .pageNumber(pageInfo.getPageNum())
                .pageNumber(pageInfo.getPageSize())
                .count(pageInfo.getTotal()).build();
    }

    private RequestPage getPageParam(Object[] args) {
        for (Object arg : args) {
            if (arg instanceof RequestPage) {
                return (RequestPage) arg;
            }
        }
        return null;
    }
}
