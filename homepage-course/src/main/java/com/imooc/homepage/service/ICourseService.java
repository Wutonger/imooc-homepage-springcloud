package com.imooc.homepage.service;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;

import java.util.List;

public interface ICourseService{

    /**
     * 通过id获取课程信息
     * @return
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过ids获取课程信息list
     * @param courseInfosRequest
     * @return
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest courseInfosRequest);
}
