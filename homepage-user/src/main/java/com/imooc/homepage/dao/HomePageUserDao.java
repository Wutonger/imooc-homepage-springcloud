package com.imooc.homepage.dao;

import com.imooc.homepage.entity.HomePageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomePageUserDao extends JpaRepository<HomePageUser,Long> {

    HomePageUser findByUsername(String username);
}
