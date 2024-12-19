package com.aipaopao.entity;

import lombok.Data;

import java.time.LocalDateTime;

// 用户
@Data
public class User
{
    private Integer userId;
    private String openId; // 用户id
    private String sessionKey; // 用户签名密钥
    private String nickname; // 用户昵称
    private String userAvatar; // 用户头像
    private String userSex; // 用户性别
    private String userBirthday; // 用户生日
    private String userTelephone; // 用户手机号
    private String role; // 用户类型 -普通用户、送货员（需注册）、管理员（数据库设定相关成员为管理员）
    private LocalDateTime loginTime; // 登录时间
    private LocalDateTime updateTime; // 用户更改个人信息时间
}
