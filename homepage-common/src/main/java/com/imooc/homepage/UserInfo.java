package com.imooc.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private Long id;

    private String username;

    private String email;

    //返回无效用户信息
    public static UserInfo invalid(){
        return new UserInfo(-1L,"","");
    }
}
