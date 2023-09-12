package cn.icexmoon.sessiondemo.controller; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : session-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/11 18:24
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import cn.icexmoon.sessiondemo.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/d")
public class ControllerD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = ServletUtil.getCookie(request, "username");
        if (username!=null){
            username = URLDecoder.decode(username, StandardCharsets.UTF_8.name());
        }
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
