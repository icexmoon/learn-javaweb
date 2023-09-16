package cn.icexmoon.logindemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller.filter
 * @ClassName : .java
 * @createTime : 2023/9/12 21:53
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 对登录相关请求和静态资源进行放行
        String[] paths = new String[]{
                "/user/login",
                "/user/registry",
                "/user/exist",
                "/user/check_code",
                "/css/",
                "/imgs/",
                "/index.jsp",
                "/js/"
        };
        if (!(request instanceof HttpServletRequest &&
                response instanceof HttpServletResponse)){
            throw new RuntimeException("This is not web Application.");
        }
        HttpServletRequest hRequest = (HttpServletRequest) request;
        HttpServletResponse hResponse = (HttpServletResponse) response;
        String url = hRequest.getRequestURL().toString();
        String prefix = "http://"+hRequest.getHeader("host")+hRequest.getContextPath();
        for (String path: paths){
            if (url.indexOf(prefix+path) == 0){
                // 符合规则，放行
                System.out.println("放行"+url);
                chain.doFilter(hRequest, hResponse);
                return;
            }
        }
        // 检查是否登录，如果没有登录，重定向到登录页面
        Object username = hRequest.getSession().getAttribute("username");
        if (username == null){
            hResponse.sendRedirect("/login-demo/user/login");
            return;
        }
        // 已经登录，放行
        chain.doFilter(hRequest, hResponse);

    }

    @Override
    public void destroy() {

    }
}
