package com.aipaopao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 统一响应结果
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T>
{
    private Integer code; // 业务状态, 1-成功, 0-失败
    private String message; // 提示信息
    private T data; // 响应数据

    public static <E> Result<E> success(E data)
    {
        return new Result<>(1,"操作成功",data);
    }

    // 快捷返回成功、失败信息
    public static Result success()
    {
        return new Result(1,"操作成功",null);
    }
    public static Result error(String message)
    {
        return new Result(0,message,null);
    }
}
