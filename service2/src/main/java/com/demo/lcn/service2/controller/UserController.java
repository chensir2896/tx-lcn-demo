package com.demo.lcn.service2.controller;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.demo.lcn.service2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
@EnableDistributedTransaction
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public String addUser(String userName){
        log.info("provider addUser");
        if(StringUtils.isEmpty(userName)){
            throw new RuntimeException("未传递userName");
        }
        userService.saveUser(userName);
        return "success";
    }
}
