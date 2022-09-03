package com.cyan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatement {
    public static void main(String[] args) {
        Connection connection = MySQLUtils.getConnection();
        Statement statement=null;

        int flag=0;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql2 = "update user set pwd = '14746465468' where name='libai'";
        try {
            flag = statement.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (flag == 1){
            System.out.println("success!");
        }else {
            System.out.println("error!");
        }

        MySQLUtils.close(connection,null,statement,null);
    }

}
