package cn.icexmoon;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App4 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 获取 JDBC 连接
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "mysql";
        @Cleanup Connection connection = DriverManager.getConnection(url, username, password);
        // 获取 SQL 执行对象
        @Cleanup Statement statement = connection.createStatement();
        // 执行 SQL
        String sql = "update tb_brand set ordered=99 where id=1";
        int rows = statement.executeUpdate(sql);
        if (rows > 0) {
            System.out.println("品牌信息修改成功");
        } else {
            System.out.println("品牌信息修改失败");
        }
    }
}
