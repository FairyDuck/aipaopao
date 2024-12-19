package com.aipaopao.mapper;

import com.aipaopao.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper
{
    // 根据用户openid查找用户
    @Select("select * from user where open_id = #{openid}")
    User findUserByOpenId(String openid);

    // 插入新用户
    @Insert("insert into user (opend_id,session_key) value (#{openid},#{sessionKey})")
    void insertNewUser(String openid, String sessionKey);

    // 更新用户session_key
    @Update("update user set session_key = #{sessionKey} where open_id =#{openid}")
    void updateUserSessionKey(String openid, String sessionKey);
}
