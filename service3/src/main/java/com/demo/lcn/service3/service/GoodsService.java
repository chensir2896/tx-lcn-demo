package com.demo.lcn.service3.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.demo.lcn.service3.entity.Goods;
import com.demo.lcn.service3.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Transactional
    @LcnTransaction
    public void saveGoods(String goodsName) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goodsMapper.saveGoods(goods);

        if(atomicInteger.incrementAndGet() % 3 == 0){
            throw new RuntimeException("error");
        }

    }
}
