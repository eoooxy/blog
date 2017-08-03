package com.doliao.mapper;

import com.doliao.po.TypePo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypePoMapper extends MyMapper<TypePo> {

    List<String> getTypeByArtId(Integer articleid);
}