package cn.icexmoon.mybatisdemo.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mybatis-demo
 * @Package : cn.icexmoon.mybatisdemo.entity
 * @ClassName : .java
 * @createTime : 2023/8/22 10:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String gender;
    private String addr;
}
