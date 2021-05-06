package com.quan.core.controller;

import com.quan.core.constant.util.StringUtil;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.annotation.SLog;
import com.quan.core.service.ValidateCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信提供
 * @author zzg
 * @date 2019/09/01
 */
@RestController
@SuppressWarnings("all")
@Api(tags = "PHONE Validate Code API")
public class SmsController {

    public final static String SYSMSG_LOGIN_PWD_MSG="验证码：{0}，3分钟内有效";

    @Autowired
    private ValidateCodeService validateCodeService;

	@RequestMapping(value = "/sms/send")
    @SLog(module="auth-server",saveRequestData=false)
    @ApiOperation(value = "根据 手机号 发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "String")
    })
    public JsonResult sendSms(@RequestParam(value = "mobile",required = false) String mobile) {
		String content = SmsController.SYSMSG_LOGIN_PWD_MSG.replace("{0}", StringUtil.generateRamdomNum());
//        SendMsgResult sendMsgResult = MobileMsgConfig.sendMsg(mobile, content);

        String calidateCode = StringUtil.generateRamdomNum();

        // TODO: 2019-08-29 发送短信验证码 每个公司对接不同，自己实现

        validateCodeService.saveImageCode(mobile, calidateCode);
        return  JsonResult.succeed(  calidateCode, "发送成功");
    }

}
