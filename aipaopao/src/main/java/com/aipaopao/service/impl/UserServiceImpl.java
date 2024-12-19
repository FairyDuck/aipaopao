package com.aipaopao.service.impl;

import com.aipaopao.entity.AboutApp;
import com.aipaopao.entity.Result;
import com.aipaopao.entity.User;
import com.aipaopao.mapper.UserMapper;
import com.aipaopao.service.UserService;
import com.aipaopao.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result loginByWechatService(String code) {
        AboutApp aboutApp = new AboutApp();
        if (code == null || code.isEmpty()) {
            return Result.error("UserCode is required!");
        }

        String url = aboutApp.getWxLoginUrl() + "?appid=" + aboutApp.getAppId() +
                "&secret=" + aboutApp.getSecret() + "&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

//        // 从官方服务器获取用户的session_key和openid
//        System.out.println("Response: " + response); // 输出响应数据

        // （json格式数据直接获取失败？-未解决）
        // 故采用直接转型字符串来遍历获取用户的session_key和openid
        if (response != null) {
            String openid = "";
            String sessionKey = "";
            int i = 16;
            for (; i < response.length(); i++) {
                if (response.charAt(i + 1) == ',') {
                    break;
                }
                sessionKey += response.charAt(i);
            }
            i += 12;
            for (; i < response.length(); i++) {
                if (response.charAt(i + 1) == '}') {
                    break;
                }
                openid += response.charAt(i);
            }
//            System.out.println("sessionKey: "+sessionKey + " openid: " + openid);

            //登录逻辑 -首次登录创建新用户 -非首次登录更新用户session_key
//            User u = userMapper.findUserByOpenId(openid);
//            if(u.getOpenId() == null)
//            {
//                userMapper.insertNewUser(openid,sessionKey);
//            }
//            else
//            {
//                userMapper.updateUserSessionKey(openid,sessionKey);
//            }

            // 使用openid生成token传给前端
            Map<String,Object> claims = new HashMap<>();
            claims.put("openid",openid);
            String token = JwtUtil.genToken(claims);
            System.out.println("token "+ token);
            System.out.println(Result.success(token));
            return Result.success(token); // 返回openid生成的token
        } else {
            return Result.error("login failed: 接口服务返回错误");
        }
    }

    // 保存用户信息
    @Override
    public Result saveUserMessage(User user, String token)
    {
        return null;
    }
}
