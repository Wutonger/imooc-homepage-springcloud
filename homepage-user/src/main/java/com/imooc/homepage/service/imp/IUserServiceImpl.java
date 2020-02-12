package com.imooc.homepage.service.imp;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.imooc.homepage.UserInfo;
import com.imooc.homepage.client.CourseClient;
import com.imooc.homepage.dao.HomePageUserCourseDao;
import com.imooc.homepage.dao.HomePageUserDao;
import com.imooc.homepage.entity.HomePageUser;
import com.imooc.homepage.entity.HomePageUserCourse;
import com.imooc.homepage.service.IUserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private HomePageUserDao homePageUserDao;

    @Autowired
    private HomePageUserCourseDao homePageUserCourseDao;

    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()){
            return UserInfo.invalid();
        }

        HomePageUser oldUser = homePageUserDao.findByUsername(request.getUsername());
        if (null != oldUser){
            return UserInfo.invalid();
        }

        HomePageUser newUser = homePageUserDao.save(new HomePageUser(request.getUsername(),request.getEmail()));
        return new UserInfo(newUser.getId(),newUser.getUsername(),newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<HomePageUser> optional = homePageUserDao.findById(id);
        if (!optional.isPresent()){
            return UserInfo.invalid();
        }
        HomePageUser homePageUser = optional.get();
        return new UserInfo(homePageUser.getId(),homePageUser.getUsername(),homePageUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<HomePageUser> optional = homePageUserDao.findById(id);
        if (!optional.isPresent()){
            return UserCourseInfo.invalid();
        }
        HomePageUser homePageUser = optional.get();
        UserInfo userInfo = new UserInfo(homePageUser.getId(),homePageUser.getUsername(),homePageUser.getEmail());
        List<HomePageUserCourse>  userCourses = homePageUserCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)){
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(new CourseInfosRequest(userCourses.stream().
                map(HomePageUserCourse::getCourseId).collect(Collectors.toList())));
        return null;
    }
}
