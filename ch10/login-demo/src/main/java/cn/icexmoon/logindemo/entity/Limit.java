package cn.icexmoon.logindemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.entity
 * @ClassName : .java
 * @createTime : 2023/9/16 20:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@AllArgsConstructor
public class Limit {
    private Integer begin;
    private Integer size;
}
