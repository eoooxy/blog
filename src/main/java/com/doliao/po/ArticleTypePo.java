package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_article_type")
public class ArticleTypePo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    private Integer typeid;

    private Integer articleid;

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
     * @return typeid
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * @param typeid
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * @return articleid
     */
    public Integer getArticleid() {
        return articleid;
    }

    /**
     * @param articleid
     */
    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
}