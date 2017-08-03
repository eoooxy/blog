package com.doliao.vo;

import java.io.Serializable;

/**
 * author： xueyuan
 * date  ： 2017-07-28 下午5:57
 */
public class LoginInfoVo implements Serializable {

    public String lasttime;
    public String currenttime;
    public String os;

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
