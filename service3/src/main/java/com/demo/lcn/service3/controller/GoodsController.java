package com.demo.lcn.service3.controller;

import com.demo.lcn.service3.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    public String saveGoods(String goodsName){
        goodsService.saveGoods(goodsName);
        return "success";
    }
}
