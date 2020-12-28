package com.quan.core.controller;

import com.google.code.kaptcha.Producer;
import com.quan.core.annotation.SLog;
import com.quan.core.service.ValidateCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 验证码提供
 * @author zlt
 * @date 2018/12/18
 */
@Controller
@Api(tags = "WEB Validate Code API")
public class ValidateCodeController {
    @Autowired
    private Producer producer;

    @Autowired
    private ValidateCodeService validateCodeService;

    /**
     * 创建验证码
     *
     * @throws Exception
     */
    @GetMapping(value = "/validata/code/{deviceId}")
    @SLog(module = "auth-server")
    @ApiOperation(value = "根据 机器码 绑定验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "机器码", required = true, dataType = "String")
    })
    public void createCode(@PathVariable String deviceId, HttpServletResponse response) throws Exception {
        Assert.notNull(deviceId, "机器码不能为空");
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        validateCodeService.saveImageCode(deviceId, text);
        try (ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(image, "JPEG", out);
        }
    }

}
