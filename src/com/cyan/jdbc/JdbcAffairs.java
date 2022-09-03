package com.cyan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcAffairs {
    public static void main(String[] args) {
        Connection connection = MySQLUtils.getConnection();
        Statement statement =null;
        String sql = "insert into user values ('tianzi','1223')";
        String sql1 = "update user set pwd = '147585' where name='tianzi'";
        String sql2 = "update user set pwd = '528' where name='libai'";

        try {//开启事务
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql1);
//            int i = 1/0;    //错误点
            statement = connection.createStatement();
            statement.executeUpdate(sql2);
            connection.commit();//若无错误，提交事务
        } catch (SQLException e) {
            try {
                connection.rollback();//报错，回滚，信息不会修改
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }


        MySQLUtils.close(connection,null,statement,null);
    }

}
