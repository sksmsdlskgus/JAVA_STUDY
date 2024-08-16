package com.ohgiraffers.section2;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/menudb";
    private static String user = "swcamp";
    private static String password = "swcamp";

    private  static SqlSessionFactory sqlSessionFactory;


    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            Environment environment =
                    new Environment("dev"
                    ,new JdbcTransactionFactory()
                    ,new PooledDataSource(driver,url,user,password));

            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

            return sqlSessionFactory.openSession(false);

        }
    }
}