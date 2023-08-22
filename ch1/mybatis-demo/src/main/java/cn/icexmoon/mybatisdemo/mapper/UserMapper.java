package cn.icexmoon.mybatisdemo.mapper;

import cn.icexmoon.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mybatis-demo
 * @Package : cn.icexmoon.mybatisdemo.mapper
 * @ClassName : .java
 * @createTime : 2023/8/22 11:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface UserMapper {
    List<User> selectAll();

    @Select("select * from tb_user where id=#{id}")
    User selectById(int id);
}
