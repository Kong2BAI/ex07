package com.util;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class DataSourceUtil implements ServletContextListener {
     @Resource(name = "jdbc/MYSQL")
     private static DataSource dataSource;
     public static Connection getConnection() throws SQLException{
          //对外暴露数据源的链接，不直接暴露数据源
          return dataSource.getConnection();
     }
}
