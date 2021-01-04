package com.quan.core.api.impl;

import com.quan.core.api.WxHandler;
import com.quan.core.enums.WxMsgType;
import com.quan.core.model.WxArticle;
import com.quan.core.model.WxInMsg;
import com.quan.core.model.WxOutMsg;
import com.quan.core.util.Wxs;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public abstract class AbstractWxHandler implements WxHandler {

    @Override
    public WxOutMsg text(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg image(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg voice(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg video(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg location(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg link(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventSubscribe(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventUnsubscribe(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventScan(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventLocation(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventClick(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventView(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventTemplateJobFinish(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg defaultMsg(WxInMsg msg) {
        if ("帮助".equals(msg.getContent()))
            return Wxs.respText(null, "支持的命令有: 你好 版本 帮助 appid 测试文本 测试新闻 回显");
        if ("你好".equals(msg.getContent()))
            return Wxs.respText(null, "你好!!");
        if ("版本".equals(msg.getContent()))
            return Wxs.respText(null, "Nutz " + Nutz.version());
        if ("appid".equals(msg.getContent()))
            return Wxs.respText(null, msg.getToUserName());
        if ("回显".equals(msg.getContent()))
            return Wxs.respText(null, Json.toJson(msg));
        if ("测试文本".equals(msg.getContent()))
            return Wxs.respText(null, "这真的是一条测试文本");
        if ("测试图片".equals(msg.getContent()))
            return Wxs.respImage(null, "not exist");
        if ("测试新闻".equals(msg.getContent())) {
            WxArticle nutzam = new WxArticle("官网", "nutz官网", "https://nutz.cn/rs/logo/logo.png", "http://nutzam.com");
            WxArticle nutzcn = new WxArticle("Nutz社区", "nutz官方社区", "https://nutz.cn/rs/logo/logo.png", "https://nutz.cn");
            return Wxs.respNews(null, nutzam, nutzcn);
        }
        if (WxMsgType.shortvideo.name().equals(msg.getMsgType())) {
            return Wxs.respText(null, "小视频?讨厌...");
        }
        return Wxs.respText("这是缺省回复哦.你发送的类型是:" + msg.getMsgType() + ". http://nutz.cn");
    }

    @Override
    public WxOutMsg handle(WxInMsg in) {
        return Wxs.handle(in, this);
    }

    @Override
    public WxOutMsg eventScancodePush(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventScancodeWaitMsg(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventScancodePicSysphoto(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventScancodePicPhotoOrAlbum(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventScancodePicWeixin(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg eventLocationSelect(WxInMsg msg) {
        return defaultMsg(msg);
    }

    @Override
    public WxOutMsg shortvideo(WxInMsg msg) {
        return defaultMsg(msg);
    }
}
