package com.doliao.service.impl;

import com.doliao.mapper.ArticlePoMapper;
import com.doliao.po.ArticlePo;
import com.doliao.service.ArticleService;
import com.doliao.vo.ArticleVo;
import com.doliao.vo.FileVo;
import com.doliao.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午3:42
 */
@Service
public class ArticleServiceImpl implements ArticleService
{

    @Autowired
    ArticlePoMapper articlePoMapper;

    @Override
    public PageInfo getArticleList(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(), pageVo.getPageSize());
        PageInfo pageInfo = new PageInfo(articlePoMapper.getArticles());
        return pageInfo;
    }

    @Override
    public List<ArticlePo> getArticleList() {
        return articlePoMapper.getArticles();
    }

    @Override
    public PageInfo getAllArticle(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPageNum(), 15);
        PageInfo pageInfo = new PageInfo(articlePoMapper.getAllArticle());
        return pageInfo;
    }

    @Override
    public ArticlePo getArticle(Integer recid) {
        return articlePoMapper.getArticle(recid);
    }

    @Override
    public void getFileList(List<ArticleVo> articleVos, List<FileVo> fileVos) {
        int num = 0;
        for (int i = 0; i < articleVos.size(); i++) {
            num++;
            if (i + 1 < articleVos.size() &&
                    !articleVos.get(i + 1).getCreatetime().substring(0, 7).equals(articleVos.get(i).getCreatetime().substring(0, 7))
                    || i + 1 == articleVos.size()) {
                FileVo fileVo = new FileVo();
                fileVo.setFiletime(articleVos.get(i).getCreatetime().substring(0, 7));
                fileVo.setNum(num);
                num = 0;
                fileVos.add(fileVo);
            }
        }
    }

    @Override
    public List<ArticlePo> filterTypeArts(String keywords) {
        return articlePoMapper.filterTypeArts(keywords);
    }

    @Override
    public List<ArticlePo> filterTimeArts(String keywords) {
        return articlePoMapper.filterTimeArts(keywords);
    }

    @Override
    public List<ArticlePo> filterTagArts(String keywords) {
        return articlePoMapper.filterTagArts(keywords);
    }

    @Override
    public int updateArticle(ArticlePo articlePo) {
        return articlePoMapper.updateByPrimaryKey(articlePo);
    }

    @Override
    public int insertArticle(ArticlePo articlePo) {
        return articlePoMapper.insertArticle(articlePo);
    }

    @Override
    public int delAndShowArt(ArticlePo articlePo) {
        return articlePoMapper.delAndShowArt(articlePo);
    }

}
