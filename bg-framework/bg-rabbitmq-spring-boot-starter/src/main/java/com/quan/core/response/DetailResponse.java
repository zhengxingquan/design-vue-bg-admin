package com.quan.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/***
 * 请求响应类
 * @author zxq(956607644 @ qq.com)
 * @date 2021/4/28 18:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailResponse {

    /***
     * 请求状态
     */
    private boolean successState;
    /***
     * 错误编码
     */
    private String errorCode;
    /***
     * 错误消息
     */
    private String errorMsg;
}
