package com.demo.lcn.service1;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDistributedTransaction
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/save")
    @LcnTransaction
	public String saveUserAndGoods(String userName,String goodsName){
        System.out.println(restTemplate);
        String resultUser = restTemplate.postForObject("http://localhost:5002/user/add?userName={userName}", "userName", String.class, userName);
        String resultGood = restTemplate.postForObject("http://localhost:5003/goods/add?goodsName={goodsName}", "goodsName", String.class, goodsName);

        return resultUser+"-"+resultGood;
	}
}
