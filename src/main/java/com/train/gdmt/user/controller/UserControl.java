package com.train.gdmt.user.controller;


import com.train.gdmt.user.model.User;
import com.train.gdmt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "用户管理")
@Controller
@RequestMapping("user")
public class UserControl {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = Logger.getLogger(UserControl.class);

    @RequestMapping("toLogin")
    @ApiOperation(value = "转到用户登录界面",notes = "转到用户登录界面",tags = "用户信息处理类")
    public String toLogin() {
        return "login-simple";
    }

    @RequestMapping("doLogin")
    @ApiOperation(value = "进行登录操作",notes = "根据登录界面传参进行登录",tags = "用户信息处理类")
    public String doLogin(String username, String password, HttpSession session, HttpServletRequest request){
        System.out.println(DigestUtils.md5Hex(password));
        User loginUser=userService.login(username);
        System.out.println(DigestUtils.md5Hex(loginUser.getPwd()));


        if(DigestUtils.md5Hex(password).equals(DigestUtils.md5Hex(loginUser.getPwd())))
        {
            session.setAttribute("loginUser",loginUser);
                    return "redirect:/article/page";
        }
        else {
            request.setAttribute("loginError","用户名和密码错误");
            return "login-simple";
        }
    }
}
