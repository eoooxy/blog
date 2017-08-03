package com.doliao.service.impl;

import com.doliao.mapper.ArticleTypePoMapper;
import com.doliao.po.ArticleTypePo;
import com.doliao.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-27 下午7:31
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    ArticleTypePoMapper articleTypePoMapper;

    @Override
    public int delArticleTypeByArtId(Integer articleid) {
        return articleTypePoMapper.delArticleTypeByArtId(articleid);
    }

    @Override
    public int insertArticleTypes(List<ArticleTypePo> articleTypePos) {
        return articleTypePoMapper.insertList(articleTypePos);
    }
}
