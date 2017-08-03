package com.doliao.service;

import com.doliao.po.UserPo;

/**
 * author： xueyuan
 * date  ： 2017-07-13 上午8:46
 */
public interface UserService {

    UserPo getUser(UserPo userPo);

    int updateUser(UserPo userPo);

}
