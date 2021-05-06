package com.quan.core.constant.reflect;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/5
 * 描述：
 *
 * 类型提炼器。针对一个类型，提炼出一组最能反应其特征的类型
 */
public interface TypeExtractor {


    Class<?>[] extract(Mirror<?> mirror);
}
