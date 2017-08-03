package com.doliao.mapper;

import com.doliao.po.ArticleTagPo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagPoMapper extends MyMapper<ArticleTagPo> {

    int delArticleTagByArtId(Integer articleid);
}