package cn.icexmoon.logindemo.service.impl;

import cn.icexmoon.logindemo.entity.User;
import cn.icexmoon.logindemo.mapper.UserMapper;
import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.util.MyBatisUtil;
import cn.icexmoon.logindemo.util.TwoTuple;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service.impl
 * @ClassName : .java
 * @createTime : 2023/9/9 20:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UserServiceImpl implements UserService {
    /**
     * 检查登录凭证（用户名+密码）是否正确
     *
     * @param userName 用户名
     * @param password 密码
     */
    public void checkLogin(String userName, String password) {
        TwoTuple<UserMapper, SqlSession> twoTuple = MyBatisUtil.getMapper(UserMapper.class);
        UserMapper userMapper = twoTuple.getA();
        SqlSession sqlSession = twoTuple.getB();
        User user = userMapper.selectByUserName(userName);
        sqlSession.close();
        if (user == null) {
            throw new RuntimeException(String.format("用户%s不存在", userName));
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
    }

    @Override
    public void register(User user) {
        TwoTuple<UserMapper, SqlSession> twoTuple = MyBatisUtil.getMapper(UserMapper.class);
        UserMapper userMapper = twoTuple.getA();
        SqlSession sqlSession = twoTuple.getB();
        try {
            User userInDB = userMapper.selectByUserName(user.getUsername());
            if (userInDB != null) {
                throw new RuntimeException(String.format("用户%s已经存在，不能重复注册", user.getUsername()));
            }
            int rows = userMapper.insert(user);
            if (rows <= 0) {
                throw new RuntimeException("数据库错误，没有插入数据。");
            }
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }
}
