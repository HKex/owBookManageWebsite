package org.hkex.owbookmanage.service;

import org.hkex.owbookmanage.entity.Borrow;

import java.util.List;

public interface BookService {
    List<Borrow> getBorrow();
}
