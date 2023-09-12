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
 * @createTime : 2023/9/11 17:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/b")
public class ControllerB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                String username = cookie.getValue();
                System.out.println("username: " + username);
                break;
            }
        }
    }
}
