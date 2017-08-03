package com.doliao.service.impl;

import com.doliao.mapper.TypePoMapper;
import com.doliao.po.TypePo;
import com.doliao.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午3:40
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypePoMapper typePoMapper;

    @Override
    public List<TypePo> getTypeList() {
        return typePoMapper.selectAll();
    }

    @Override
    public List<String> getTypeListByArtId(Integer articleid) {
        return typePoMapper.getTypeByArtId(articleid);
    }

    @Override
    public TypePo getType(Integer recid) {
        TypePo typePo = new TypePo();
        typePo.setRecid(recid);
        return typePoMapper.selectOne(typePo);
    }

    @Override
    public int updateType(TypePo typePo) {
        return typePoMapper.updateByPrimaryKey(typePo);
    }

    @Override
    public int insertType(TypePo typePo) {
        return typePoMapper.insert(typePo);
    }
}
