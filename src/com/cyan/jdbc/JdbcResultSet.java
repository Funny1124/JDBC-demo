package com.cyan.jdbc;

import com.cyan.pojo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcResultSet {
    public static void main(String[] args) throws  Exception{
        Connection connection = MySQLUtils.getConnection();
        Statement statement;
        ResultSet resultSet;

        statement = connection.createStatement();

        String sql = "select * from user";

        resultSet = statement.executeQuery(sql);

//        while (resultSet.next()){//判断是否为有效行
//            System.out.println(resultSet.getString(1));//根据列号读取数据
//            System.out.println(resultSet.getString(2));
//            System.out.println("-------------");
//        }



//        while (resultSet.next()){//判断是否为有效行
//            System.out.println(resultSet.getString("name"));//根据表头读取数据
//            System.out.println(resultSet.getString("pwd"));
//            System.out.println("-------------");
//        }


        List<User> userList = new ArrayList<>();
        while (resultSet.next()){//判断是否为有效行
            User user = new User();//封装数据
            String name = resultSet.getString("name");  //根据表头读取数据
            String pwd = resultSet.getString("pwd");
            user.setName(name);
            user.setPwd(pwd);
            userList.add(user);
        }
        System.out.println(userList);

        MySQLUtils.close(connection,null,statement,resultSet);
    }

}
