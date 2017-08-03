package com.doliao.mapper;

import com.doliao.po.ArticleTypePo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypePoMapper extends MyMapper<ArticleTypePo> {

    int delArticleTypeByArtId(Integer articleid);
}