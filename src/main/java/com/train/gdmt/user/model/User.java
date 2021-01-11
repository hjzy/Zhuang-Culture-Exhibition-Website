package com.train.gdmt.user.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: YIFAN.SUN
 * @Date: 2020/7/27 10:10
 */

@Data//自动生成set和get方法
public class User {
    private int id;
    private String userId;
    private String pwd;
    private String userName;
    private String email;
    private String telephone;
}

