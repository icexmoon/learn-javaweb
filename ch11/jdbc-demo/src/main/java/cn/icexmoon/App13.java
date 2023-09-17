package cn.icexmoon;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.Cleanup;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 使用数据库连接池进行连接
 */
public class App13 {
    private static DataSource dataSource;
    static {
        // 从配置文件读取数据库连接信息
        Properties properties = new Properties();
        InputStream propertiesStream = App13.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            // 加载数据库连接信息到 Properties
            properties.load(propertiesStream);
            try {
                // 创建 Druid 数据库连接池
                dataSource = DruidDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        @Cleanup Connection connection = dataSource.getConnection();
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
