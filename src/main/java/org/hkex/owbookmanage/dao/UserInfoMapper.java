package org.hkex.owbookmanage.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.hkex.owbookmanage.entity.UserInfo;

public interface UserInfoMapper {

    @Insert("insert into userinfo(id, coinBalance) VALUES (#{id},#{coinBalance})")
    boolean insertUserInfo(@Param("id")int id,@Param("coinBalance") int coinBalance);

    @Select("select * from userinfo where id = #{id}")
    UserInfo getUserInfo(@Param("id")int id);

    @Update("update userinfo set coinBalance = #{coinBalance} where id = #{id} ")
    boolean updateUserInfo(@Param("id")int id,@Param("coinBalance") int coinBalance);
}
