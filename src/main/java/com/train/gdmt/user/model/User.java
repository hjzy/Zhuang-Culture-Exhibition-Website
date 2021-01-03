package com.train.gdmt.user.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:10
 */

@Data//自动生成set和get方法
public class User {

    private int id;
    private String userId;
    private String pwd;
    private String userName;
    private String email;
    private String units;
    private String telephone;
    private String role;   //1：燃料业务员 2：监察人员 3：管理人员 4：系统管理员 5：公告发布员',
    private String department;//1:燃料部 2:审批部 3：宣传部 4：管理部
    private String address;
}

