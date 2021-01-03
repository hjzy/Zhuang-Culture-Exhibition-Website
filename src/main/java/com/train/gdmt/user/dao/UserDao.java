package com.train.gdmt.user.dao;

import com.train.gdmt.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:09
 */



@Mapper//表示mybatis中负责实体和sql映射的类
@Repository//注册userdao作为一个bean
public interface UserDao {


    @Select("select * from User where username=#{username}")
    User getUser(String username);



}
