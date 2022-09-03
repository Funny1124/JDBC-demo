package com.cyan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPrepareStatement {
    public static void main(String[] args) throws Exception{
        Connection connection = MySQLUtils.getConnection();
        PreparedStatement preparedStatement= null;
        Statement statement =null;
        ResultSet resultSet=null;

//        statement=connection.createStatement();
//        String name = "''or '1'='1'";
//        String sql1 = "select * from user where name ="+name;
//        //拼接后为  select * from user where name = ''or '1'='1' ，即永远为ture
//        resultSet = statement.executeQuery(sql1);

        String sql = "select * from user where name = ? ";
        preparedStatement = connection.prepareStatement(sql);//预编译，提高性能，防sql注入

        preparedStatement.setString(1,"libai");//根据问号index设置参数
//        preparedStatement.setString(1,"''or '1'='1'");

        //检测到 ’ 时 会进行转义 \'\'or\'1\'=\'1\',达到防sql注入的目的
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){//判断是否为有效行
            System.out.println(resultSet.getString("name"));//根据表头读取数据
            System.out.println(resultSet.getString("pwd"));
        }

        MySQLUtils.close(connection,preparedStatement,statement,resultSet);
    }

}
