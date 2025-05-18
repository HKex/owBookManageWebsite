package org.hkex.owbookmanage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.hkex.owbookmanage.entity.Borrow;

import java.util.List;

public interface BookMapper{

    @Results({
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "username", property = "username"),
            @Result(column = "sid", property = "student_id")
    })
    @Select("SELECT * FROM borrow,book,user WHERE book.bid = borrow.bid and borrow.sid = user.id")
    List<Borrow> queryAllBorrow();
}
