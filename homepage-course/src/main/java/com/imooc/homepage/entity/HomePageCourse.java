package com.imooc.homepage.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_course")
public class HomePageCourse {

    /** 数据表主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** 课程名称 */
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /** 课程类型: 0(免费课), 1(实战课) */
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    /** 课程图标 */
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    /** 课程介绍 */
    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    /** 创建时间 */
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /** 更新时间 */
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public HomePageCourse(String courseName, Integer courseType,
                          String courseIcon, String courseIntro) {

        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    /**
     * 返回一个无效的课程
     * */
    public static HomePageCourse invalid() {

        HomePageCourse invalid = new HomePageCourse("", 0, "", "");
        invalid.setId(-1L);
        return invalid;
    }
}
