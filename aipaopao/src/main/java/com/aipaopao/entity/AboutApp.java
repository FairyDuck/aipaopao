package com.aipaopao.entity;

import lombok.Data;

@Data
public class AboutApp
{
    // appId
    private static final String appId = "wx7b145680235bddb9";
    // secret
    private static final String secret = "5e9058252968524f780ed87aff84b142";
    // url -用于获取用户openid和session_key
    private static final String wxLoginUrl = "https://api.weixin.qq.com/sns/jscode2session";
    public static String getAppId() {
        return appId;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getWxLoginUrl() {
        return wxLoginUrl;
    }
}
