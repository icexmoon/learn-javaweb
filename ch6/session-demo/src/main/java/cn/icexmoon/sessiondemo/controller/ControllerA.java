package cn.icexmoon.sessiondemo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : session-demo
 * @Package : cn.icexmoon.sessiondemo.controller
 * @ClassName : .java
 * @createTime : 2023/9/11 17:19
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/a")
public class ControllerA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向浏览器添加 cookie
        Cookie cookie = new Cookie("username", "icexmoon");
        Cookie cookie1 = new Cookie("msg", "hello");
        // 设置有效时间为 1 天
        cookie.setMaxAge(1 * 24 * 60 * 60);
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }
}
