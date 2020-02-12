package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomePageCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomePageCourseDao extends JpaRepository<HomePageCourse,Long> {

}
