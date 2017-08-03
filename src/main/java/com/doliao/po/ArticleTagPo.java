package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_article_tag")
public class ArticleTagPo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    private Integer tagid;

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
     * @return tagid
     */
    public Integer getTagid() {
        return tagid;
    }

    /**
     * @param tagid
     */
    public void setTagid(Integer tagid) {
        this.tagid = tagid;
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