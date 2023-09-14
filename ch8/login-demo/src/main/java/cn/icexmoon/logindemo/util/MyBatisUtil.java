package cn.icexmoon.logindemo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.util
 * @ClassName : .java
 * @createTime : 2023/9/9 20:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 获取全局（唯一）的 SqlSessionFactory 实例
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        InputStream stream;
        if (sqlSessionFactory == null) {
            try {
                stream = Resources.getResourceAsStream("mybatis-config.xml");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        }
        return sqlSessionFactory;
    }

    /**
     * 打开一个新 SqlSession 连接，并返回 Mapper 实例
     *
     * @param mapperCls mapper 接口的类对象
     * @param <T>       mapper 接口的类型
     * @return mapper 实例和新打开的 SqlSession 对象
     */
    public static <T> TwoTuple<T, SqlSession> getMapper(Class<T> mapperCls) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        T mapper = sqlSession.getMapper(mapperCls);
        return new TwoTuple<T, SqlSession>(mapper, sqlSession);
    }
}
