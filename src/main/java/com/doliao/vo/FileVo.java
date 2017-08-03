package com.doliao.vo;

import java.io.Serializable;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午6:07
 */
public class FileVo implements Serializable {
    private String filetime;
    private Integer num;

    public String getFiletime() {
        return filetime;
    }

    public void setFiletime(String filetime) {
        this.filetime = filetime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
