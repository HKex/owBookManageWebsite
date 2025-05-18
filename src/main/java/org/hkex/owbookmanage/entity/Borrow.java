package org.hkex.owbookmanage.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Borrow {

    int book_id;
    String book_name;
    Date time;
    String username;
    int student_id;
}
