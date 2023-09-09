package cn.icexmoon.logindemo.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.util
 * @ClassName : .java
 * @createTime : 2023/9/9 21:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ControllerUtil {
    public static void checkParamNotEmpty(String param){
        if (param == null || param.isEmpty()){
            throw new RuntimeException("输入参数不能为空");
        }
    }
}
