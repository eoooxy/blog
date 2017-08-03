package com.doliao.vo;

import java.io.Serializable;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-27 上午10:14
 */
public class ArtFilterVo implements Serializable {

    private String title;
    private List<ArticleVo> voList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ArticleVo> getVoList() {
        return voList;
    }

    public void setVoList(List<ArticleVo> voList) {
        this.voList = voList;
    }
}
