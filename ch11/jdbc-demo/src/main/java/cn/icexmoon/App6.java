package cn.icexmoon;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App6 {
    public static void main(String[] args) throws Exception {
        // 获取 JDBC 连接
        String url = "jdbc:mysql:///jdbc_demo?useSSL=false";
        String username = "root";
        String password = "mysql";
        @Cleanup Connection connection = DriverManager.getConnection(url, username, password);
        // 获取 SQL 执行对象
        @Cleanup Statement statement = connection.createStatement();
        // 执行 SQL
        // 开启事务
        connection.setAutoCommit(false);
        try{
            String sql1 = "update tb_brand set ordered=66 where id=1";
            statement.executeUpdate(sql1);
            int i = 1/0;
            String sql2 = "update tb_brand set ordered=66 where id=2";
            statement.executeUpdate(sql2);
            // 提交事务
            connection.commit();
        }
        catch (Exception e){
            // 回滚事务
            connection.rollback();
            throw e;
        }
    }
}
