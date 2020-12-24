package com.quan.uid.controller;

import com.quan.uid.service.UidGenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/24
 * 描述：
 */
@RestController("/uid-generator")
@Api(tags = "获取分布式全局ID")
@RequestMapping("/uid")
public class UidController {


    @Autowired
    private UidGenService uidGenService;

    @GetMapping("/next")
    @ApiOperation(value = "获取分布式ID")
    public String test() {
        return String.valueOf(uidGenService.getUid());
    }
}
