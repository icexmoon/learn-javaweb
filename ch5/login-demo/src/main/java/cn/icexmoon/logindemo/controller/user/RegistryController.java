package cn.icexmoon.logindemo.controller.user; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : login-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/9 21:34
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import cn.icexmoon.logindemo.entity.User;
import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import cn.icexmoon.logindemo.util.ControllerUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/registry")
public class RegistryController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String htmlTemplate = "<html><h1>%s</h1></html>";
        try {
            ControllerUtil.checkParamNotEmpty(username);
            ControllerUtil.checkParamNotEmpty(password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            response.setHeader("Content-Type", "text/html; charset=utf-8");
            response.getWriter().println(String.format(htmlTemplate, "注册失败：" + e.getMessage()));
            return;
        }
        // 注册成功，重定向到登录页
        response.sendRedirect("/login-demo/login.html");
    }
}
