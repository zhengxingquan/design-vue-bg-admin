package com.quan.core.api;

import com.quan.core.model.WxKfAccount;

import java.io.File;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public interface WxCustomServiceApi {

    List<WxKfAccount> getkflist();

    List<WxKfAccount> getonlinekflist();

    WxResp kfaccount_add(String kf_account, String nickname, String password);

    WxResp kfaccount_update(String kf_account, String nickname, String password);

    WxResp kfaccount_uploadheadimg(String kf_account, File f);

    WxResp kfaccount_del(String kf_account);
}
