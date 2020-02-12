package com.imooc.homepage.client;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 通过Feign访问课程微服务
 */
@FeignClient(value = "eureka-client-homepage-course",fallback = CourseClientHystrix.class)  //指定服务名
public interface CourseClient {

    @GetMapping(value = "/homepage-course/get/course")
    CourseInfo getCourseInfo(Long id);

    @PostMapping(value = "/homepage-course/get/courses")
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);

}
