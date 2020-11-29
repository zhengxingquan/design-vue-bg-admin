package com.quan.oauth.server.controller;

import com.quam.common.util.StringUtil;
import com.quam.common.web.Result;
import com.quan.log.annotation.SLog;
import com.quan.oauth.server.service.ValidateCodeService;
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
public class SmsController {

    public final static String SYSMSG_LOGIN_PWD_MSG="验证码：{0}，3分钟内有效";

    @Autowired
    private ValidateCodeService validateCodeService;

	@RequestMapping("/sms/send")
    @SLog(module="auth-server",saveRequestData=false)
    public Result sendSms(@RequestParam(value = "mobile",required = false) String mobile) {
		String content = SmsController.SYSMSG_LOGIN_PWD_MSG.replace("{0}", StringUtil.generateRamdomNum());
//        SendMsgResult sendMsgResult = MobileMsgConfig.sendMsg(mobile, content);

        String calidateCode = StringUtil.generateRamdomNum();

        // TODO: 2019-08-29 发送短信验证码 每个公司对接不同，自己实现

        validateCodeService.saveImageCode(mobile, calidateCode);
        return  Result.succeed(  calidateCode, "发送成功");
    }

}
