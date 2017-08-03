package com.doliao.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog_type")
public class TypePo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recid;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 更新时间
     */
    private String updatetime;

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
     * 获取类型名称
     *
     * @return name - 类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类型名称
     *
     * @param name 类型名称
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}