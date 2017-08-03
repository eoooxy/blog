package com.doliao.vo;

import java.io.Serializable;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午4:02
 */
public class TagVo implements Serializable {

    private Integer recid;

    private String name;

    private String createtime;

    private String updatetime;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
