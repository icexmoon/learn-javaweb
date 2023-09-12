package cn.icexmoon.filterdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-demo
 * @Package : cn.icexmoon.filterdemo.filter
 * @ClassName : .java
 * @createTime : 2023/9/12 21:44
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebFilter("/*")
public class Filter1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("before filter1 chain.doFilter");
        chain.doFilter(request, response);
        System.out.println("after filter1 chain.doFilter");
    }

    public void destroy() {

    }
}
