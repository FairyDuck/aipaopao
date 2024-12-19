package com.aipaopao.controller;

import com.aipaopao.entity.Result;
import com.aipaopao.entity.User;
import com.aipaopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserControler
{
    @Autowired
    private UserService userService;

    // 登录
    @GetMapping("/login")
    public Result loginByWechatService(String code)
    {
//        System.out.println("login + code: " + code);
        return userService.loginByWechatService(code);
    }

    // 保存个人信息
    @PostMapping("/saveUserMessage")
    public Result saveUserMessage(@RequestBody User user, HttpServletRequest request)
    {
        String Token = request.getHeader("Authorization");
        String token = Token.substring(7);
        System.out.println(user);
        // 解析token获取openid判断用户更新数据库
        return userService.saveUserMessage(user, token);
    }
}
