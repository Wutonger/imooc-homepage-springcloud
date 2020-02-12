package com.imooc.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfo {
    private Long id;

    private String courseName;

    private String courseType;

    private String courseIcon;

    private String courseIntro;

    //返回无效的课程信息
    public static CourseInfo invalid(){
        return new CourseInfo(-1L,"","","","");
    }
}
