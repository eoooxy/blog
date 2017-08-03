package com.utils;

import java.util.UUID;

public final class UUIDUtil {

    /**
     * 生成UUID(小写)
     * @return
     */
    public static String genLowerUUID(){
        return UUID.randomUUID().toString().toLowerCase();
    }

    /**
     * 生成大写的UUID
     * @return
     */
    public static String genUpperUUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 生成紧凑型（不带"-"）的UUID(小写)
     * @return
     */
    public static String getCompactLowerUUID(){
        return genLowerUUID().replace("-","");
    }

    /**
     * 生成紧凑型（不带"-"）的UUID(大写)
     * @return
     */
    public static String getCompactUpperUUID(){
        return genUpperUUID().replace("-","");
    }
}
