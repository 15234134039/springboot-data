package com.it.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看默认的数据源 com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        //获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接
        connection.close();

    }

}
