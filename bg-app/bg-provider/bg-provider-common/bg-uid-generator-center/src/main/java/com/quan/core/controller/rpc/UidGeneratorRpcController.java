package com.quan.core.controller.rpc;

import com.quan.core.service.IUidGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/24
 * 描述：
 */
@RestController
@RequestMapping("/uid-generator-rpc")
public class UidGeneratorRpcController {

    @Autowired
    private IUidGeneratorService uidGenService;

    @GetMapping("/getUID")
    public String getUID() {
        return String.valueOf(uidGenService.getUID());
    }

    @GetMapping("/parseUID")
    public String parseUID(@RequestParam Long uid) {
        return uidGenService.parseUID(uid);
    }
}
