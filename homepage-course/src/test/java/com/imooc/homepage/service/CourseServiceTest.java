package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.Application;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.dao.HomePageCourseDao;
import com.imooc.homepage.entity.HomePageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class CourseServiceTest {

    @Autowired
    private HomePageCourseDao courseDao;

    @Autowired
    private ICourseService service;

    @Test
    public void testCreateCourseInfo(){
        HomePageCourse homePageCourse = new HomePageCourse("于ElasticSearch实现博客检索系统",0,
                "https://www.imooc.com","带你入门ElasticSearch的使用");
        HomePageCourse homePageCourse1 = new HomePageCourse("Spark+ElasticSearch实现千人千面的推荐系",1,
                "https://www.imooc.com","大数据Spark+ES的实战课程");

        courseDao.saveAll(Arrays.asList(homePageCourse,homePageCourse1));
    }

    @Test
    public void testGetCourseInfo() {

        System.out.println(JSON.toJSONString(service.getCourseInfo(6L)));
        System.out.println(JSON.toJSONString(service.getCourseInfo(11L)));
    }

    @Test
    public void testGetCourseInfos() {

        System.out.println(JSON.toJSONString(service.getCourseInfos(
                new CourseInfosRequest(Arrays.asList(6L, 7L, 8L))
        )));
    }
}
