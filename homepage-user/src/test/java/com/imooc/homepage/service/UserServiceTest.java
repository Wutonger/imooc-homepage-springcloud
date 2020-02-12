package com.imooc.homepage.service;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.Application;
import com.imooc.homepage.dao.HomePageUserCourseDao;
import com.imooc.homepage.entity.HomePageUserCourse;
import com.imooc.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomePageUserCourseDao userCourseDao;

    @Test
    public void testCreateUser() {

        System.out.println(JSON.toJSONString(userService.createUser(
                new CreateUserRequest("qinyi_02", "qinyi_02@imooc.com")
        )));
    }

    @Test
    public void testGetUser() {

        System.out.println(JSON.toJSONString(userService.getUserInfo(7L)));
    }

    @Test
    public void testCreateHomepageUserCourse() {

        HomePageUserCourse course1 = new HomePageUserCourse();
        course1.setUserId(6L);
        course1.setCourseId(6L);

        HomePageUserCourse course2 = new HomePageUserCourse();
        course2.setUserId(6L);
        course2.setCourseId(7L);

        System.out.println(userCourseDao.saveAll(Arrays.asList(course1,course2)));
    }
}
