package com.quan.core.controller;

import com.quan.core.common.web.Result;
import com.quan.core.service.IUidGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/24
 * 描述：
 */
@RestController("/uid-generator")
@Api(tags = "获取分布式全局ID")
public class UidGeneratorController {


    @Autowired
    private IUidGeneratorService uidGenService;

    @GetMapping("/uid")
    @ApiOperation(value = "获取分布式ID")
    public Result test() {
        return Result.succeed(uidGenService.getUID());
    }
}
