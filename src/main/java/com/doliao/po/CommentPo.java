package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_msg")
public class CommentPo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 创建时间
     */
    private String createtime;

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


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取消息内容
     *
     * @return msg - 消息内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置消息内容
     *
     * @param msg 消息内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}