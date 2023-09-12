package cn.icexmoon.sessiondemo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : session-demo
 * @Package : cn.icexmoon.sessiondemo.util
 * @ClassName : .java
 * @createTime : 2023/9/11 18:25
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class ServletUtil {
    /**
     * 获取指定 Cookie 的值
     * @param request 请求对象
     * @param name Cookie 名称
     * @return Cookie 的值
     */
    public static String getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                String value = cookie.getValue();
                return value;
            }
        }
        return null;
    }
}
