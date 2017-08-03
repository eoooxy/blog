package com.doliao.service.impl;

import com.doliao.mapper.UserPoMapper;
import com.doliao.po.UserPo;
import com.doliao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author： xueyuan
 * date  ： 2017-07-13 上午8:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPoMapper userPoMapper;


    @Override
    public UserPo getUser(UserPo userPo) {
        return userPoMapper.selectOne(userPo);
    }

    @Override
    public int updateUser(UserPo userPo) {
        return userPoMapper.updateByPrimaryKey(userPo);
    }
}
