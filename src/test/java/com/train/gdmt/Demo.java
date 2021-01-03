package com.train.gdmt;

import com.train.gdmt.user.model.User;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:20
 */
public class Demo {


    public static void main(String[] args) {

        User user = new User();
        user.setEmail("xiuzhong.li@qq.com");
        user.setId(1);
        System.out.println(user.getEmail());
        System.out.println(user);



    }



}
