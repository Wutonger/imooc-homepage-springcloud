package com.imooc.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    private String email;

    /**
     * 数据有效性验证
     * @return
     */
    public boolean validate(){
        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
