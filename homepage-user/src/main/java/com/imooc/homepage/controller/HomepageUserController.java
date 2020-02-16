package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.UserInfo;
import com.imooc.homepage.client.CourseClient;
import com.imooc.homepage.service.IUserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户对外服务接口
 */
@Slf4j
@RestController
public class HomepageUserController {

    /** 用户服务 */
    private final IUserService userService;

    @Autowired
    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    private CourseClient courseClient;

    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")},ignoreExceptions = {NullPointerException.class})   //使用Hystrix自带方式服务降级
    @GetMapping("/get/coursePort")
    public String getCoursePort(){
        return courseClient.getPort();
    }


    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {

        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }


    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {

        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }


    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {

        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }


    public String fallbackMethod(){
        return "10010";
    }
}
