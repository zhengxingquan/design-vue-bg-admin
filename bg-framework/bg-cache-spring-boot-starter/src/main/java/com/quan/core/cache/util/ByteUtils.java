package com.quan.core.cache.util;

import java.io.*;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2021/1/11
 * 描述：
 */
public class ByteUtils {

    public static byte[] toBytes(Object obj) {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(obj);
            return bao.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> T fromBytes(byte[] buf, Class<T> klass) {
        try {
            return (T) new ObjectInputStream(new ByteArrayInputStream(buf)).readObject();
        }
        catch (ClassNotFoundException e) {
            return null;
        }
        catch (IOException e) {
            return null;
        }
    }

}
