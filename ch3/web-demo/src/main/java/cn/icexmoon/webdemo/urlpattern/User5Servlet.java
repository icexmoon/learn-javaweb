package cn.icexmoon.webdemo.urlpattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo.urlpattern
 * @ClassName : .java
 * @createTime : 2023/9/8 16:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 以注解方式配置 servlet
 */
public class User5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("User5Servlet...");
    }
}
