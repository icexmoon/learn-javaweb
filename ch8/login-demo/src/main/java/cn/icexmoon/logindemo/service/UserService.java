package cn.icexmoon.logindemo.service;

import cn.icexmoon.logindemo.entity.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service
 * @ClassName : .java
 * @createTime : 2023/9/9 20:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserService {
    void checkLogin(String userName, String password);

    void register(User user);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return
     */
    boolean checkUsernameExists(String username);

    /**
     * 根据用户名获取用户信息
     * @return 用户信息
     */
    User getUserByUserName(String userName);
}
