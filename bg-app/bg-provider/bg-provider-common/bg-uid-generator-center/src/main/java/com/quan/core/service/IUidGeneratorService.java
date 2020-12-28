package com.quan.core.service;

import com.quan.core.exception.UidGenerateException;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/25
 * 描述：
 */
public interface IUidGeneratorService {

    /**
     * Get a unique ID
     *
     * @return UID
     * @throws UidGenerateException
     */
    Long getUID() throws UidGenerateException;

    /**
     * Parse the UID into elements which are used to generate the UID. <br>
     * Such as timestamp & workerId & sequence...
     *
     * @param uid
     * @return Parsed info
     */
    String parseUID(long uid);

}
