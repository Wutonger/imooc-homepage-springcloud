package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomePageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageUserCourseDao extends JpaRepository<HomePageUserCourse,Long> {

    List<HomePageUserCourse>  findAllByUserId(Long id);
}
