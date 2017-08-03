package com.doliao.service;

import com.doliao.po.TagPo;
import com.doliao.vo.TagVo;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-24 下午11:35
 */
public interface TagService {

    List<TagPo> getTagList();

    List<String> getTagListByArtId(Integer articleid);

    TagPo getTag(Integer recid);

    int updateTag(TagPo tagPo);

    int insertTag(TagPo tagPo);
}
