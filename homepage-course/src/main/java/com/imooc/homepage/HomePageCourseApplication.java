package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringCloudApplication
@EnableJpaAuditing  //帮助管理create_time与update_time
public class HomePageCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageCourseApplication.class,args);
    }
}
