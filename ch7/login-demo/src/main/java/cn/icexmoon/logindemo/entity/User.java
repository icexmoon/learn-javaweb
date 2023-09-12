package cn.icexmoon.logindemo.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.entity
 * @ClassName : .java
 * @createTime : 2023/9/9 20:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
