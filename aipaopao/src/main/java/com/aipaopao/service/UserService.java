package com.aipaopao.service;

import com.aipaopao.entity.Result;
import com.aipaopao.entity.User;

import java.util.Map;

public interface UserService
{
    // 用户登录
    Result loginByWechatService(String code);

    // 保存用户信息
    Result saveUserMessage(User user, String token);
}
