package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_user")
public class UserPo implements Serializable {
    @Id
    @Column(name = "recId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信id
     */
    private Integer wechat;

    /**
     * qq号码
     */
    private Integer oicq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像url地址
     */
    private String icon;

    /**
     * logo的url地址
     */
    private String logo;

    /**
     * 最后登录时间
     */
    private String lasttime;

    /**
     * @return recId
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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取微信id
     *
     * @return wechat - 微信id
     */
    public Integer getWechat() {
        return wechat;
    }

    /**
     * 设置微信id
     *
     * @param wechat 微信id
     */
    public void setWechat(Integer wechat) {
        this.wechat = wechat;
    }

    /**
     * 获取qq号码
     *
     * @return oicq - qq号码
     */
    public Integer getOicq() {
        return oicq;
    }

    /**
     * 设置qq号码
     *
     * @param oicq qq号码
     */
    public void setOicq(Integer oicq) {
        this.oicq = oicq;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取头像url地址
     *
     * @return icon - 头像url地址
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置头像url地址
     *
     * @param icon 头像url地址
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取logo的url地址
     *
     * @return logo - logo的url地址
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置logo的url地址
     *
     * @param logo logo的url地址
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取最后登录时间
     *
     * @return lasttime - 最后登录时间
     */
    public String getLasttime() {
        return lasttime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lasttime 最后登录时间
     */
    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
}