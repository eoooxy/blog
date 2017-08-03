package com.doliao.service;

import com.doliao.po.ArticlePo;
import com.doliao.vo.ArticleVo;
import com.doliao.vo.FileVo;
import com.doliao.vo.PageVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * author： xueyuan
 * date  ： 2017-07-24 下午11:36
 */
public interface ArticleService {

    PageInfo getArticleList(PageVo pageVo);

    List<ArticlePo> getArticleList();

    PageInfo getAllArticle(PageVo pageVo);

    ArticlePo getArticle(Integer recid);

    void getFileList(List<ArticleVo> articleVos, List<FileVo> fileVos);

    List<ArticlePo> filterTypeArts(String keywords);

    List<ArticlePo> filterTimeArts(String keywords);

    List<ArticlePo> filterTagArts(String keywords);

    int updateArticle(ArticlePo articlePo);

    int insertArticle(ArticlePo articlePo);

    int delAndShowArt(ArticlePo articlePo);
}
