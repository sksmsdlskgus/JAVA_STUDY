package com.ohgiraffers.section03;


import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuService {
    public void removeMenu(Menu removeMenu) {

        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.deleteMenu(con, removeMenu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);


    }
}

