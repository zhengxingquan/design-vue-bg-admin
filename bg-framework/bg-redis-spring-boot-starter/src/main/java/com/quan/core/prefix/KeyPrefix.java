package com.quan.core.prefix;

/***
 *   
 * @author zxq(956607644@qq.com)  
 * @date 2020/11/24 19:44

 * @return   
 */  
public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();

}
