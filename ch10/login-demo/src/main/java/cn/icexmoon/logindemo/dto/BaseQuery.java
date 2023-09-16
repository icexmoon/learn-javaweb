package cn.icexmoon.logindemo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.dto
 * @ClassName : .java
 * @createTime : 2023/9/16 19:49
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Setter
@Getter
abstract public class BaseQuery<T> {
    protected T query;
    protected Page page;
}
