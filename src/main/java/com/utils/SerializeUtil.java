package com.utils;

import org.apache.ibatis.cache.CacheException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * author： xueyuan
 * date  ： 2017-08-01 下午3:19
 */
public class SerializeUtil {
    /**
     * 序列化工具类
     */
    public SerializeUtil() {
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] e = baos.toByteArray();
            return e;
        } catch (Exception var4) {
            throw new CacheException(var4);
        }
    }

    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            ByteArrayInputStream bais = null;

            try {
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream e = new ObjectInputStream(bais);
                return e.readObject();
            } catch (Exception var3) {
                throw new CacheException(var3);
            }
        }
    }
}
