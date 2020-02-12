package com.imooc.homepage.client;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 调用课程微服务失败后进行熔断降级的策略
 */
@Component
public class CourseClientHystrix  implements CourseClient{

    /**
     * 调用失败后返回无效的课程信息
     * @param id
     * @return
     */
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    /**
     * 调用失败后返回空的课程列表
     * @param request
     * @return
     */
    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
