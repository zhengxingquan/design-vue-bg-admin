package com.quan.core.common.annotation.batis;

import com.quan.core.common.enume.DB;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * 描述：
 * <p>
 * 为 '@Next' 以及 '@Prev' 注解声明的可执行 EL。
 * <p>
 * 不同于 '@SQL' 注解的字符串模板形式，本占位符提供的是一段 EL 表达式代码。
 * 就是说，你可以执行一份我函数调用。调用的方式请自行参看"EL表达式的语法"，文档上有 这里不解释。
 * <p>
 * EL 表达式的的上下文变量可以是:
 * <ul>
 * <li>view: 表示当前实体对象的视图名称 (since 1.b.49)
 * <li>field: 表示注解所在字段数据库名称 (since 1.b.49)
 * <li>me : 表示 POJO 对象本身
 * <li>所有的 POJO Java 字段名
 * </ul>
 * <p>
 * 比如你如果想让你的主键采用 UUID 那么你可以这么声明
 *
 * <pre>
 * public class Pet {
 *
 *  &#64;Name
 *  &#64;Prev(els=@EL("$me.genID()"))
 *  // 或者 // &#64;Prev(els=@EL("uuid()"))
 *  private String id;
 *
 *  public String genID(){
 *      return org.nutz.lang.random.R.UU16();
 *  }
 *      ...
 * }
 * </pre>
 */
public @interface EL {

    /***
     * 数据库类型
     */  
    DB db() default DB.OTHER;

    /***
     * 具体的表达式值
     */
    String value();
}
