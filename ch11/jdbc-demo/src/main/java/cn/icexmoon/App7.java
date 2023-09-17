package cn.icexmoon;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App7 {
    public static void main(String[] args) throws Exception {
        // 获取 JDBC 连接
        String url = "jdbc:mysql:///jdbc_demo?useSSL=false";
        String username = "root";
        String password = "mysql";
        @Cleanup Connection connection = DriverManager.getConnection(url, username, password);
        // 获取 SQL 执行对象
        @Cleanup Statement statement = connection.createStatement();
        // 执行 SQL
        String sql1 = "update tb_brand set ordered=99 where id=1";
        int rows = statement.executeUpdate(sql1);
        if (rows > 0){
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }
    }
}
