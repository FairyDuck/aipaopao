package com.aipaopao.entity;

import lombok.Data;

import java.time.LocalDateTime;

// 订单
@Data
public class Order
{
    private Integer orderId; // 订单编号 -自增
    private String emitUser; // 订单发起者
    private String receiveUser; // 订单接收者
    private Double amount; // 订单金额
    private String startPosition; // 取货地址
    private String aimPosition; // 送达目标地址
    private String image; // 订单图片
    private String number; // 单号
    private String statue; // 订单状态 -待接单、配送中、已完成、已删除
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间 -接单、送达
}
