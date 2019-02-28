package com.demo.lcn.service2.mapper;

import com.demo.lcn.service2.entity.User;

import java.util.List;

public interface UserMapper {


    List<User> listAllUser();

    void saveUser(User user);

    User getUserById(Integer userId);
}
