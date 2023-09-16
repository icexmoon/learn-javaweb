package cn.icexmoon.logindemo.controller.user;

import cn.icexmoon.logindemo.entity.User;
import cn.icexmoon.logindemo.service.UserService;
import cn.icexmoon.logindemo.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller.user
 * @ClassName : .java
 * @createTime : 2023/9/14 17:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/user/info")
public class InfoController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        User user = userService.getUserByUserName(username);
        resp.getWriter().print(JSON.toJSONString(user));
    }
}
