package com.quan.core.util;

import java.util.UUID;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/1
 * 描述：
 */
public abstract class R {

    private static final char[] _UU64 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] _UU32 = "0123456789abcdefghijklmnopqrstuv".toCharArray();
    private static final char[] _C = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray();


    public static String UU32(UUID uu) {
        StringBuilder sb = new StringBuilder();
        long m = uu.getMostSignificantBits();
        long l = uu.getLeastSignificantBits();
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (m >> ((13 - i - 1) * 5)) & 31]);
        }
        for (int i = 0; i < 13; i++) {
            sb.append(_UU32[(int) (l >> ((13 - i - 1)) * 5) & 31]);
        }
        return sb.toString();
    }

    public static String UU32() {
        return UU32(UUID.randomUUID());
    }
}
