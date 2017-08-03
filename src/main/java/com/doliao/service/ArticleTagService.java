package com.doliao.service;

import com.doliao.po.ArticleTagPo;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-27 下午7:30
 */
public interface ArticleTagService {

    int delArticleTagByArtId(Integer articleid);

    int insertArticleTags(List<ArticleTagPo> articleTagPos);
}
