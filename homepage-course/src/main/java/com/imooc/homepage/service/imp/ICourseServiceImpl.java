package com.imooc.homepage.service.imp;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.dao.HomePageCourseDao;
import com.imooc.homepage.entity.HomePageCourse;
import com.imooc.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ICourseServiceImpl implements ICourseService {

    @Autowired
    private HomePageCourseDao homePageCourseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomePageCourse> course = homePageCourseDao.findById(id);
        return bulidCourseInfo(course.orElse(HomePageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest courseInfosRequest) {
        if (CollectionUtils.isEmpty(courseInfosRequest.getIds())){
            return Collections.emptyList();
        }
        List<HomePageCourse> list = homePageCourseDao.findAllById(courseInfosRequest.getIds());
        //使用stream()简化操作
        return list.stream()
                .map(this::bulidCourseInfo)
                .collect(Collectors.toList());
    }


    private CourseInfo bulidCourseInfo(HomePageCourse course){
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程":"实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
