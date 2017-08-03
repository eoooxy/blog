package com.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于复制相同属性名的值(反之也可以) 未经严格测试 目前仅限使用于getter setter属性的复制
 * author:  xueyuan
 * date  :  2017-07-05 11:48.
 */
public class ModelCopyUtil {

    public static void copy(Object from, Object to){
        try {
            BeanUtils.copyProperties(to, from);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        jdk 1.8写法

//        Method[] toMethods = to.getClass().getDeclaredMethods();
//
//        Method[] formMethods = from.getClass().getDeclaredMethods();
//
//        List<String> toMethodNames = Arrays.stream(to.getClass().getDeclaredMethods()).filter(i -> i.getName().startsWith("set")).map(i -> i.getName().substring(3)).collect(Collectors.toList());
//
//        Arrays.stream(formMethods).filter(i -> (toMethodNames.contains(i.getName().substring(3)) && i.getName().contains("get"))).forEach(i -> {
//            try {
//                Object value = i.invoke(from);
//                if (value != null) {
//                    Method method = findMethodByName(toMethods, "set" + i.getName().substring(3));
//                    if (method != null)
//                        method.invoke(to, value);
//                }
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        });
//
//        //针对boolean类型自动生成得 getter方法为is开头的
//        Arrays.stream(formMethods).filter(i -> (toMethodNames.contains(i.getName().substring(2)) && i.getName().contains("is"))).forEach(i -> {
//            try {
//                Object value = i.invoke(from);
//                if (value != null) {
//                    Method method = findMethodByName(toMethods, "set" + i.getName().substring(2));
//                    if (method != null)
//                        method.invoke(to, value);
//                }
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//
//    private static Method findMethodByName(Method[] methods, Object name) {
//        for (Method method : methods) {
//            if (method.getName().equals(name))
//                return method;
//        }
//        return null;
//    }

    }
}
