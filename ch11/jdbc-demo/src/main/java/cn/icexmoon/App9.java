package cn.icexmoon;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App9 {
    public static void main(String[] args) throws Exception {
        // 获取 JDBC 连接
        String url = "jdbc:mysql:///jdbc_demo?useSSL=false";
        String username = "root";
        String password = "mysql";
        @Cleanup Connection connection = DriverManager.getConnection(url, username, password);
        // 获取 SQL 执行对象
        @Cleanup Statement statement = connection.createStatement();
        // 执行 SQL
        String sql = "select * from tb_brand where id<5";
        @Cleanup ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String brandName = resultSet.getString(2);
            String companyName = resultSet.getString(3);
            System.out.println(String.format("%d[brandName:%s,companyName:%s]", id, brandName, companyName));
        }
    }
}
