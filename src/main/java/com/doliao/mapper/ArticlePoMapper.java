package com.doliao.mapper;

import com.doliao.po.ArticlePo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArticlePoMapper extends MyMapper<ArticlePo> {

    List<ArticlePo> getArticles();

    List<ArticlePo> getAllArticle();

    ArticlePo getArticle(Integer recid);

    List<ArticlePo> filterTypeArts(String keywords);

    List<ArticlePo> filterTimeArts(String keywords);

    List<ArticlePo> filterTagArts(String keywords);

    int insertArticle(ArticlePo articlePo);

    int delAndShowArt(ArticlePo articlePo);
}