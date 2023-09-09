package cn.icexmoon.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo
 * @ClassName : .java
 * @createTime : 2023/9/8 17:39
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 request method
        String method = req.getMethod();
        System.out.println("Request Method: " + method);
        // 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("Context Path: " + contextPath);
        // 获取 URL
        StringBuffer url = req.getRequestURL();
        System.out.println("URL: " + url.toString());
        // 获取 URI
        String uri = req.getRequestURI();
        System.out.println("URI: " + uri);
        // 获取请求参数
        String queryString = req.getQueryString();
        System.out.println("Query String: " + queryString);
        this.printHeaders(req);
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("------------headers------------");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hn = headerNames.nextElement();
            Enumeration<String> headerValues = req.getHeaders(hn);
            List<String> hvList = new ArrayList<>();
            while (headerValues.hasMoreElements()) {
                String hv = headerValues.nextElement();
                hvList.add(hv);
            }
            System.out.println(String.format("%s: %s", hn, String.join(",", hvList)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 后去请求的字符输入流
        BufferedReader br = req.getReader();
        // 对输入流逐行打印
        String line;
        do {
            line = br.readLine();
            if (line != null) {
                System.out.println(line);
            }
        }
        while (line != null);
    }
}
