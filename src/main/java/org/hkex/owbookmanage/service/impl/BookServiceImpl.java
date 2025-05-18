package org.hkex.owbookmanage.service.impl;

import jakarta.annotation.Resource;
import org.hkex.owbookmanage.dao.BookMapper;
import org.hkex.owbookmanage.entity.Borrow;
import org.hkex.owbookmanage.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper mapper;

    @Override
    public List<Borrow> getBorrow() {
            return mapper.queryAllBorrow();
    }
}
