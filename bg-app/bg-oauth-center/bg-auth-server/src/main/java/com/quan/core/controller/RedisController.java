package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.constant.RedisConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/***
 *   redis 管理
 * @author zxq(956607644 @ qq.com)
 * @date 2021/2/4 16:51
 */
@RestController
@Api(tags = "（REDIS CENTER）REDIS 管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "REDIS管理", permission = "sys:redis")
@RequestMapping("/sys/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/memory/info")
    @ApiOperation(value = "redis内存信息")
    @SLog(module = "auth-server", tag = "REDIS 内存信息")
    public Result getMemoryInfo() throws ControllerException {

        Map<String, Object> map = new HashMap<>();

        Object o = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return Optional.ofNullable(
                        connection.info(RedisConstant.MEMORY))
                        .orElseThrow(RuntimeException::new)
                        .get(RedisConstant.USED_MEMORY);
            }
        });
        map.put(RedisConstant.USED_MEMORY, o);
        map.put(RedisConstant.CREATE_TIME, System.currentTimeMillis());
        return JsonResult.succeed(map);
    }


    @ResponseBody
    @GetMapping("/key/size")
    @ApiOperation(value = "redis键值信息")
    @SLog(module = "auth-server", tag = "REDIS 键值信息")
    public Result getKeysSize() throws ControllerException {
        Map<String, Object> map = new HashMap<>();

        Object o = redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
        map.put(RedisConstant.DB_SIZE, o);
        map.put(RedisConstant.CREATE_TIME, System.currentTimeMillis());

        return JsonResult.succeed(map);
    }

}
