package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_links")
public class LinksPo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    /**
     * 友情链接名称
     */
    private String name;

    /**
     * 友情链接地址
     */
    private String url;

    /**
     * 排序标志，数字从大到小
     */
    private Integer sort;

    /**
     * @return recid
     */
    public Integer getRecid() {
        return recid;
    }

    /**
     * @param recid
     */
    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    /**
     * 获取友情链接名称
     *
     * @return name - 友情链接名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置友情链接名称
     *
     * @param name 友情链接名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取友情链接地址
     *
     * @return url - 友情链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置友情链接地址
     *
     * @param url 友情链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取排序标志，数字从大到小
     *
     * @return sort - 排序标志，数字从大到小
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序标志，数字从大到小
     *
     * @param sort 排序标志，数字从大到小
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}