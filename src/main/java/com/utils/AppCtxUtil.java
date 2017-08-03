package com.utils;

import org.springframework.context.ApplicationContext;

/**
 * author:  xueyuan
 * date  :  2017-07-05 10:11.
 */
public class AppCtxUtil {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        AppCtxUtil.applicationContext = applicationContext;
    }


}
