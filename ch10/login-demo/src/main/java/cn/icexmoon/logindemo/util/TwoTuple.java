package cn.icexmoon.logindemo.util;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.util
 * @ClassName : .java
 * @createTime : 2023/9/9 20:56
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
public class TwoTuple <A,B>{
    private final A a;
    private final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}
