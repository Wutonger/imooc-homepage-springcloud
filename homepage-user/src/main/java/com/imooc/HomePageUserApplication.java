package com.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringCloudApplication
@EnableFeignClients  //使用Feign远程调用
@EnableJpaAuditing
public class HomePageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageUserApplication.class,args);
    }
}
