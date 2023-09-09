package cn.icexmoon.webdemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : web-demo
 * @Package : cn.icexmoon.webdemo
 * @ClassName : .java
 * @createTime : 2023/9/8 22:12
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        this.printParams(req);
        this.printFirstVal(req, "hobby");
        this.printAllVals(req, "hobby");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        this.printParams(req);
        this.printFirstVal(req, "hobby");
        this.printAllVals(req, "hobby");
    }

    /**
     * 打印所有的请求参数
     * @param req
     */
    private void printParams(HttpServletRequest req) {
        // 打印所有请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach((pName, pValues) -> {
            System.out.println(String.format("%s: %s", pName, String.join(",", pValues)));
        });
    }

    /**
     * 打印指定参数的第一个值
     * @param req
     * @param paramName
     */
    private void printFirstVal(HttpServletRequest req, String paramName) {
        String parameter = req.getParameter(paramName);
        System.out.println(String.format("%s's first value is %s", paramName, parameter));
    }

    /**
     * 打印请求参数的所有值
     * @param req
     * @param paramName
     */
    private void printAllVals(HttpServletRequest req, String paramName) {
        String[] values = req.getParameterValues(paramName);
        System.out.println(String.format("%s's all values is %s", paramName, String.join(",", values)));
    }
}
