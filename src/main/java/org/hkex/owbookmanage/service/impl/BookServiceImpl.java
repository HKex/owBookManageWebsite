package org.hkex.owbookmanage.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.hkex.owbookmanage.dao.BookMapper;
import org.hkex.owbookmanage.entity.Borrow;
import org.hkex.owbookmanage.service.BookService;
import org.hkex.owbookmanage.util.MybatisUtil;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrow() {
        try(SqlSession session = MybatisUtil.getSession()){
            BookMapper mapper = session.getMapper(BookMapper.class);
            return mapper.queryAllBorrow();
        }
    }
}
