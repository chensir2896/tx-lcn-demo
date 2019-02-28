package com.demo.lcn.service2.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.demo.lcn.service2.entity.User;
import com.demo.lcn.service2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @LcnTransaction
    public void saveUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        userMapper.saveUser(user);
    }
}
