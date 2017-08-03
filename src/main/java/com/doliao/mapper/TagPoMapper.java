package com.doliao.mapper;

import com.doliao.po.TagPo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagPoMapper extends MyMapper<TagPo> {

    List<String> getTagByArtId(Integer articleid);
}