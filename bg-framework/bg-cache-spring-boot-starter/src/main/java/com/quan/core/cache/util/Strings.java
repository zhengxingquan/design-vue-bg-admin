package com.quan.core.cache.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public final class Strings {

    /**
     * 对指定对象进行 toString 操作；如果该对象为 null ，则返回空串（""）
     *
     * @param obj
     *            指定的对象
     * @return 对指定对象进行 toString 操作；如果该对象为 null ，则返回空串（""）
     */
    public static String sNull(Object obj) {
        return sNull(obj, "");
    }

    /**
     * 对指定对象进行 toString 操作；如果该对象为 null ，则返回默认值
     *
     * @param obj
     *            指定的对象
     * @param def
     *            默认值
     * @return 对指定对象进行 toString 操作；如果该对象为 null ，则返回默认值
     */
    public static String sNull(Object obj, String def) {
        return obj != null ? obj.toString() : def;
    }

    /**
     * 对指定对象进行 toString 操作；如果该对象为 null ，则返回空串（""）
     *
     * @param obj
     *            指定的对象
     * @return 对指定对象进行 toString 操作；如果该对象为 null ，则返回空串（""）
     */
    public static String sBlank(Object obj) {
        return sBlank(obj, "");
    }

    /**
     * 对指定对象进行 toString 操作；如果该对象为 null 或者 toString 方法为空串（""），则返回默认值
     *
     * @param obj
     *            指定的对象
     * @param def
     *            默认值
     * @return 对指定对象进行 toString 操作；如果该对象为 null 或者 toString 方法为空串（""），则返回默认值
     */
    public static String sBlank(Object obj, String def) {
        if (null == obj)
            return def;
        String s = obj.toString();
        return Strings.isBlank(s) ? def : s;
    }

    /**
     * 复制字符
     *
     * @param c
     *            字符
     * @param num
     *            数量
     * @return 新字符串
     */
    public static String dup(char c, int num) {
        if (c == 0 || num < 1)
            return "";
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < num; i++)
            sb.append(c);
        return sb.toString();
    }

    /**
     * 将字符串首字母大写
     *
     * @param s
     *            字符串
     * @return 首字母大写后的新字符串
     * @deprecated 推荐使用 {@link #upperFirst(CharSequence)}
     */
    @Deprecated
    public static String capitalize(CharSequence s) {
        return upperFirst(s);
    }

    /**
     * 将字符串首字母小写
     *
     * @param s
     *            字符串
     * @return 首字母小写后的新字符串
     */
    public static String lowerFirst(CharSequence s) {
        if (null == s)
            return null;
        int len = s.length();
        if (len == 0)
            return "";
        char c = s.charAt(0);
        if (Character.isLowerCase(c))
            return s.toString();
        return new StringBuilder(len).append(Character.toLowerCase(c))
                .append(s.subSequence(1, len))
                .toString();
    }

    /**
     * 将字符串首字母大写
     *
     * @param s
     *            字符串
     * @return 首字母大写后的新字符串
     */
    public static String upperFirst(CharSequence s) {
        if (null == s)
            return null;
        int len = s.length();
        if (len == 0)
            return "";
        char c = s.charAt(0);
        if (Character.isUpperCase(c))
            return s.toString();
        return new StringBuilder(len).append(Character.toUpperCase(c))
                .append(s.subSequence(1, len))
                .toString();
    }

    /**
     * 检查两个字符串的忽略大小写后是否相等.
     *
     * @param s1
     *            字符串A
     * @param s2
     *            字符串B
     * @return true 如果两个字符串忽略大小写后相等,且两个字符串均不为null
     */
    public static boolean equalsIgnoreCase(String s1, String s2) {
        return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);
    }

    /**
     * 检查两个字符串是否相等.
     *
     * @param s1
     *            字符串A
     * @param s2
     *            字符串B
     * @return true 如果两个字符串相等,且两个字符串均不为null
     */
    public static boolean equals(String s1, String s2) {
        return s1 == null ? s2 == null : s1.equals(s2);
    }

    /**
     * 判断字符串是否以特殊字符开头
     *
     * @param s
     *            字符串
     * @param c
     *            特殊字符
     * @return 是否以特殊字符开头
     */
    public static boolean startsWithChar(String s, char c) {
        return null != s ? (s.length() == 0 ? false : s.charAt(0) == c) : false;
    }

    /**
     * 判断字符串是否以特殊字符结尾
     *
     * @param s
     *            字符串
     * @param c
     *            特殊字符
     * @return 是否以特殊字符结尾
     */
    public static boolean endsWithChar(String s, char c) {
        return null != s ? (s.length() == 0 ? false : s.charAt(s.length() - 1) == c) : false;
    }

    /**
     * 如果此字符串为 null 或者为空串（""），则返回 true
     *
     * @param cs
     *            字符串
     * @return 如果此字符串为 null 或者为空，则返回 true
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.length() == 0;
    }

    /**
     * 如果此字符串为 null 或者全为空白字符，则返回 true
     *
     * @param cs
     *            字符串
     * @return 如果此字符串为 null 或者全为空白字符，则返回 true
     */
    public static boolean isBlank(CharSequence cs) {
        if (null == cs)
            return true;
        int length = cs.length();
        for (int i = 0; i < length; i++) {
            if (!(Character.isWhitespace(cs.charAt(i))))
                return false;
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 去掉字符串前后空白字符。空白字符的定义由Character.isWhitespace来判断
     *
     * @param cs
     *            字符串
     * @return 去掉了前后空白字符的新字符串
     */
    public static String trim(CharSequence cs) {
        if (null == cs)
            return null;
        int length = cs.length();
        if (length == 0)
            return cs.toString();
        int l = 0;
        int last = length - 1;
        int r = last;
        for (; l < length; l++) {
            if (!Character.isWhitespace(cs.charAt(l)))
                break;
        }
        for (; r > l; r--) {
            if (!Character.isWhitespace(cs.charAt(r)))
                break;
        }
        if (l > r)
            return "";
        else if (l == 0 && r == last)
            return cs.toString();
        return cs.subSequence(l, r + 1).toString();
    }

    public static String trimLeft(CharSequence cs) {
        if (null == cs)
            return null;
        int length = cs.length();
        if (length == 0)
            return cs.toString();
        int l = 0;
        for (; l < length; l++) {
            if (!Character.isWhitespace(cs.charAt(l)))
                break;
        }
        if ((length - 1) == l)
            return "";
        if (l > 0)
            return cs.subSequence(l, length).toString();
        return cs.toString();
    }

    public static String trimRight(CharSequence cs) {
        if (null == cs)
            return null;
        int length = cs.length();
        if (length == 0)
            return cs.toString();
        int last = length - 1;
        int r = last;
        for (; r > 0; r--) {
            if (!Character.isWhitespace(cs.charAt(r)))
                break;
        }
        if (0 == r)
            return "";
        if (r == last)
            return cs.toString();
        return cs.subSequence(0, r + 1).toString();
    }

    /**
     * 将给定字符串，变成 "xxx...xxx" 形式的字符串
     *
     * @param str
     *            字符串
     * @param len
     *            最大长度
     * @return 紧凑的字符串
     */
    public static String brief(String str, int len) {
        if (Strings.isBlank(str) || (str.length() + 3) <= len)
            return str;
        int w = len / 2;
        int l = str.length();
        return str.substring(0, len - w) + " ... " + str.substring(l - w);
    }

    /**
     * 将字符串按半角逗号，拆分成数组，空元素将被忽略
     *
     * @param s
     *            字符串
     * @return 字符串数组
     */
    public static String[] splitIgnoreBlank(String s) {
        return Strings.splitIgnoreBlank(s, ",");
    }

    /**
     * 根据一个正则式，将字符串拆分成数组，空元素将被忽略
     *
     * @param s
     *            字符串
     * @param regex
     *            正则式
     * @return 字符串数组
     */
    public static String[] splitIgnoreBlank(String s, String regex) {
        if (null == s)
            return null;
        String[] ss = s.split(regex);
        List<String> list = new LinkedList<String>();
        for (String st : ss) {
            if (isBlank(st))
                continue;
            list.add(trim(st));
        }
        return list.toArray(new String[list.size()]);
    }
}
