package com.cyan.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 数据库连接池
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{
        //加载配置文件
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get("src/druid.properties")));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection= dataSource.getConnection();

        System.out.println(dataSource);
        System.out.println(connection);
    }
}
