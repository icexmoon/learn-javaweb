package cn.icexmoon.logindemo.controller;

import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import cn.icexmoon.logindemo.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller
 * @ClassName : .java
 * @createTime : 2023/9/9 20:42
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String htmlTemplate = "<html><h1>%s</h1></html>";
        try {
            ControllerUtil.checkParamNotEmpty(username);
            ControllerUtil.checkParamNotEmpty(password);
            userService.checkLogin(username, password);
            writer.println(String.format(htmlTemplate, "登录成功！"));
        } catch (Exception e) {
            // 登录失败
            e.printStackTrace();
            writer.println(String.format(htmlTemplate, "登录失败：" + e.getMessage()));
        }
    }
}
