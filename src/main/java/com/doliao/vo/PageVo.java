package com.doliao.vo;

import java.io.Serializable;

/**
 * author： xueyuan
 * date  ： 2017-07-25 下午3:44
 */
public class PageVo implements Serializable {

    //当前页 默认1
    private Integer pageNum;
    //每页数量大小 默认为6
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 6 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
