package com.quan.core.constant.annotation.batis;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/6
 * <p>
 * 对象插入前的自动执行
 * <p>
 * 本注解声明在一个 POJO 的数据库字段上（带有 '@Column' 注解的字段）<br>
 * 当插入一个对象之前，通过一个 SQL 从数据库中获取值，并赋予该字段。
 * <p>
 * <b style=color:red>注意：</b> 你的字段只能允许是字符型的，或者是整数型的。否则会报错。
 * <p>
 * 除此之外，还可以通过 EL 表达式来设置值。
 */
public @interface Prev {

    SQL[] value() default {};

    EL[] els() default {};

}
