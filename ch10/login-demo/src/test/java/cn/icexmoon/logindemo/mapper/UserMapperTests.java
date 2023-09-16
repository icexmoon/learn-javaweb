package cn.icexmoon.logindemo.mapper;

import cn.icexmoon.logindemo.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.mapper
 * @ClassName : .java
 * @createTime : 2023/9/9 20:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UserMapperTests {
    @Test
    public void testSelectByUserName(){
        SqlSessionFactory sf = MyBatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sf.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        sqlSession.close();
    }
}
