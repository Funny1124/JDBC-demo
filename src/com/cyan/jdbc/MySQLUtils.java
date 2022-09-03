package com.cyan.jdbc;

import java.sql.*;

public class MySQLUtils {
    //数据库地址
    private static final String URL="jdbc:mysql://139.9.119.150:3306/jdbcTest?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    //取得驱动程序
    private static final String DRIVER="com.mysql.jdbc.Driver";
    //取得用户
    private static final String USER="dbadmin";
    //登录密码
    private static final String PASSWORD="Manager123.";
    //静态代码块加载驱动类信息
    static {
        try {
            Class.forName(DRIVER);//将"com.mysql.jdbc.Driver"类的Class类对象加载到运行时内存中
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义获取Connection对象的方法
    public static Connection getConnection() {
        //定义Connection对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn, PreparedStatement preparedStatement, Statement statement, ResultSet resultSet) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {

            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {

            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
