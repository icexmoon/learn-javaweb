package cn.icexmoon.logindemo.service;

import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service
 * @ClassName : .java
 * @createTime : 2023/9/9 21:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class UserServiceTests {
    private UserService userService = new UserServiceImpl();
    @Test
    public void testCheckLogin(){
        userService.checkLogin("zhangsan", "123");
    }
}
