package com.doliao.po;

import javax.persistence.*;

@Table(name = "blog_article_msg")
public class ArticleMsgPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    private Integer msgid;

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
     * @return msgid
     */
    public Integer getMsgid() {
        return msgid;
    }

    /**
     * @param msgid
     */
    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
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