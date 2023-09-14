package cn.icexmoon.logindemo.controller.user;

import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import cn.icexmoon.logindemo.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
public class LoginController extends HttpServlet {
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
            username = URLEncoder.encode(username, StandardCharsets.UTF_8.name());
            req.getSession().setAttribute("username", username);
            // 记住用户勾选时，保存用户名和密码到 Cookie
            String remember = req.getParameter("remember");
            if ("on".equals(remember)) {
                Cookie cu = new Cookie("username", username);
                Cookie cp = new Cookie("password", password);
                int aWeek = 7 * 24 * 60 * 60;
                cu.setMaxAge(aWeek);
                cp.setMaxAge(aWeek);
                resp.addCookie(cu);
                resp.addCookie(cp);
                //写入用户勾选
                Cookie cr = new Cookie("remember", remember);
                cr.setMaxAge(aWeek);
                resp.addCookie(cr);
            } else {
                // 记住用户不勾选，让 Cookie 中的用户名和密码过期
                Cookie cu = new Cookie("username", null);
                Cookie cp = new Cookie("password", null);
                cu.setMaxAge(0);
                cp.setMaxAge(0);
                resp.addCookie(cu);
                resp.addCookie(cp);
                Cookie cr = new Cookie("remember", "off");
                cr.setMaxAge(0);
                resp.addCookie(cr);
            }
            resp.sendRedirect("/login-demo/html/brand/list.html");
        } catch (Exception e) {
            // 登录失败
            e.printStackTrace();
            String errorMsg = "登录失败：" + e.getMessage();
            req.setAttribute("errorMsg", errorMsg);
            this.doGet(req, resp);
        }
    }

    /**
     * 加载登录页面
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/user/login.jsp").forward(req, resp);
    }
}
