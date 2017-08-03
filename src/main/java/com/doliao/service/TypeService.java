package com.doliao.service;

import com.doliao.po.TypePo;
import com.doliao.vo.TypeVo;

import java.lang.reflect.Type;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-24 下午11:35
 */
public interface TypeService {

    List<TypePo> getTypeList();

    List<String> getTypeListByArtId(Integer articleid);

    TypePo getType(Integer recid);

    int updateType(TypePo typePo);

    int insertType(TypePo typePo);

}
