package com.ohgiraffers.section03;


import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuService {
    public void deleteMenu(Menu deleteMenu) {

        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.deleteMenu(con, deleteMenu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);


    }
}

