package com.doliao.service.impl;

import com.doliao.mapper.TagPoMapper;
import com.doliao.po.TagPo;
import com.doliao.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午3:41
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagPoMapper tagPoMapper;

    @Override
    public List<TagPo> getTagList() {
        return tagPoMapper.selectAll();
    }

    @Override
    public List<String> getTagListByArtId(Integer articleid) {
        return tagPoMapper.getTagByArtId(articleid);
    }

    @Override
    public TagPo getTag(Integer recid) {
        TagPo tagPo = new TagPo();
        tagPo.setRecid(recid);
        return tagPoMapper.selectOne(tagPo);
    }

    @Override
    public int updateTag(TagPo tagPo) {
        return tagPoMapper.updateByPrimaryKey(tagPo);
    }

    @Override

    public int insertTag(TagPo tagPo) {
        return tagPoMapper.insert(tagPo);
    }
}
