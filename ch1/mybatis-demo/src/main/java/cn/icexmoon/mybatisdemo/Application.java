package cn.icexmoon.mybatisdemo;

import cn.icexmoon.mybatisdemo.entity.User;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mybatis-demo
 * @Package : cn.icexmoon.mybatisdemo
 * @ClassName : .java
 * @createTime : 2023/8/22 10:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        //获取 SqlSessionFactory 对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行SQL查询
        List<User> users = sqlSession.selectList("cn.icexmoon.mybatisdemo.test.selectAll");
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
