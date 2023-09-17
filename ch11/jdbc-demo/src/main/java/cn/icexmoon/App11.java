package cn.icexmoon;

import lombok.Cleanup;

import java.sql.*;

/**
 * 用 PrepareStatement 解决 SQL 注入攻击
 */
public class App11 {
    public static void main(String[] args) throws Exception {
        login("zhangsan", "123");
        login("zhangsan", "111");
        login("abc", "' or '1'='1");
    }

    /**
     * 执行登录操作
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功/失败
     */
    private static boolean login(String username, String password) throws Exception {
        //查询数据库，如果有用户名和密码的数据，就视为用户名和密码正确，登录成功
        // 获取 JDBC 连接
        String url = "jdbc:mysql:///jdbc_demo?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "mysql";
        @Cleanup Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
        // 获取 SQL 执行对象
        String sql = "select * from tb_user where username=? and password=? limit 1";
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        // 执行 SQL
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // 查询到结果，登录成功
            System.out.println(String.format("登录成功...[username:%s,password:%s]",
                    username, password));
            return true;
        }
        // 没有查询到结果，登录失败
        System.out.println(String.format("登录失败...[username:%s,password:%s]",
                username, password));
        return false;
    }
}
