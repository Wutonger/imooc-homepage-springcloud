package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class HomePageCourseController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ICourseService courseService;

    @GetMapping("get/port")
    public String getPort(){
       return port;
    }

    @GetMapping("get/course")
    public CourseInfo getCourseInfo(Long id){
        log.info("<homepage-course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request){
        log.info("<homepage-course>: get courses -> {}" , JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
