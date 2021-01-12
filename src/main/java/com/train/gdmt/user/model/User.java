package com.train.gdmt.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: YIFAN.SUN
 * @Date: 2020/7/27 10:10
 */

@Data//自动生成set和get方法
@ApiModel(value = "用户类",description ="请求参数类" )
public class User {
    @ApiModelProperty(example = "1",notes = "用户编号")
    private int id;
    @ApiModelProperty(example = "12123123",notes = "用户id")
    private String userId;
    @ApiModelProperty(example = "123456",notes = "用户密码")
    private String pwd;
    @ApiModelProperty(example = "yifan",notes = "用户名")
    private String userName;
    @ApiModelProperty(example = "yifan@yifansun.cn",notes = "用户邮箱")
    private String email;
    @ApiModelProperty(example = "18176662222",notes = "用户电话号码")
    private String telephone;
}

