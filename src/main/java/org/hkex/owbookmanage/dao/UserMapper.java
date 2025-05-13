package org.hkex.owbookmanage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hkex.owbookmanage.entity.User;

public interface UserMapper {

    @Select("select * from admin where username = #{username} and password = #{password}")
    User getAdmin(@Param("username")String username, @Param("password")String password);

    @Select("select * from user where username = #{username} and password = #{password}")
    User getUser(@Param("username")String username, @Param("password")String password);

    @Select("select * from user where username = #{username}")
    User getUserByName(@Param("username")String username);

    @Insert("insert into user(username,nickname,password) VALUES (#{username},#{nickname},#{password})")
    boolean insertUser(@Param("username")String username, @Param("nickname")String nickname, @Param("password")String password);

}
