package cn.icexmoon.filterdemo.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-demo
 * @Package : cn.icexmoon.filterdemo.filter
 * @ClassName : .java
 * @createTime : 2023/9/12 20:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
//@WebFilter("/*")
public class FirstFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("pre chain.doFilter");
        // 放行请求
        chain.doFilter(request, response);
        System.out.println("after chain.doFilter");
    }

    public void destroy() {

    }
}
