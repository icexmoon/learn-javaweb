package cn.icexmoon.sessiondemo.controller; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : session-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/11 18:15
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/c")
public class ControllerC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "魔芋红茶";
        username = URLEncoder.encode(username, StandardCharsets.UTF_8.name());
        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
