package cn.icexmoon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : jdbc-demo
 * @Package : cn.icexmoon
 * @ClassName : .java
 * @createTime : 2023/9/17 11:07
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class App2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载 MySQL 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取 JDBC 连接
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "mysql";
        Connection connection = DriverManager.getConnection(url, username, password);
        try {
            // 获取 SQL 执行对象
            Statement statement = connection.createStatement();
            try {
                // 执行 SQL
                String sql = "update tb_brand set ordered=99 where id=1";
                int rows = statement.executeUpdate(sql);
                if (rows > 0) {
                    System.out.println("品牌信息修改成功");
                } else {
                    System.out.println("品牌信息修改失败");
                }
            } finally {
                // 清理资源
                if (statement != null) {
                    statement.close();
                }
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
