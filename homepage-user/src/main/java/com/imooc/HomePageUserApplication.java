package com.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients  //使用Feign远程调用
@EnableJpaAuditing
@EnableDiscoveryClient
public class HomePageUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageUserApplication.class,args);
    }
}
