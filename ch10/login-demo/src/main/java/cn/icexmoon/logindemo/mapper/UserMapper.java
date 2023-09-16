package cn.icexmoon.logindemo.mapper;

import cn.icexmoon.logindemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.mapper
 * @ClassName : .java
 * @createTime : 2023/9/9 19:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserMapper {
    @Select("select * from tb_user where username=#{userName} limit 1")
    User selectByUserName(String userName);

    @Insert("insert into tb_user(username, password) VALUES (#{username},#{password})")
    int insert(User user);
}
