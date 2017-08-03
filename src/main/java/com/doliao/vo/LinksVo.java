package com.doliao.vo;

import java.io.Serializable;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午4:03
 */
public class LinksVo implements Serializable {

    private Integer recid;

    private String name;

    private String url;
    private Integer sort;

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
