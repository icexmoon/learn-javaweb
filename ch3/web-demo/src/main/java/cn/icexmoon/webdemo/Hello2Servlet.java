package cn.icexmoon.webdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo
 * @ClassName : .java
 * @createTime : 2023/9/8 12:16
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/hello2")
public class Hello2Servlet extends HttpServletTemplate{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("From post request.");
        System.out.println("Hello World2!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("From get request.");
        System.out.println("Hello World2!");
    }
}
