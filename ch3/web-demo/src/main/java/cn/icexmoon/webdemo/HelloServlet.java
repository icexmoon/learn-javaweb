package cn.icexmoon.webdemo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo
 * @ClassName : .java
 * @createTime : 2023/9/8 10:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet(value = "/hello", loadOnStartup = 1)
public class HelloServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet init...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        switch (request.getMethod()){
            case "GET":
                System.out.println("From get request.");
                break;
            case "POST":
                System.out.println("From post request.");
                break;
            default:
        }
        System.out.println("Hello World!");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("Servlet destroy...");
    }
}
