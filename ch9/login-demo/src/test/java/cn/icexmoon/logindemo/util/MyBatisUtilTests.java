package cn.icexmoon.logindemo.util;

import cn.icexmoon.logindemo.entity.User;
import cn.icexmoon.logindemo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.util
 * @ClassName : .java
 * @createTime : 2023/9/9 20:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyBatisUtilTests {
    @Test
    public void testGetMapper(){
        TwoTuple<UserMapper, SqlSession> twoTuple = MyBatisUtil.getMapper(UserMapper.class);
        User user = twoTuple.getA().selectByUserName("zhangsan");
        System.out.println(user);
        twoTuple.getB().close();
    }
}
