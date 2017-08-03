package com.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * author： xueyuan
 * date  ： 2017-07-11 下午1:37
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
