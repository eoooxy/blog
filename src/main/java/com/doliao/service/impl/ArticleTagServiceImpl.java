package com.doliao.service.impl;

import com.doliao.mapper.ArticleTagPoMapper;
import com.doliao.po.ArticleTagPo;
import com.doliao.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-27 下午7:31
 */
@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    ArticleTagPoMapper articleTagPoMapper;

    @Override
    public int delArticleTagByArtId(Integer articleid) {
        return articleTagPoMapper.delArticleTagByArtId(articleid);
    }

    @Override
    public int insertArticleTags(List<ArticleTagPo> articleTagPos) {
        return articleTagPoMapper.insertList(articleTagPos);
    }
}
