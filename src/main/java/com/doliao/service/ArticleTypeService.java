package com.doliao.service;

import com.doliao.po.ArticleTypePo;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-27 下午7:30
 */
public interface ArticleTypeService {

    int delArticleTypeByArtId(Integer articleid);

    int insertArticleTypes(List<ArticleTypePo> articleTypePos);

}
