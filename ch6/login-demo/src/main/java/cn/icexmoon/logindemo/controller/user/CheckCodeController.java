package cn.icexmoon.logindemo.controller.user; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : login-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/12 17:56
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import cn.icexmoon.logindemo.util.CheckCodeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/user/check_code")
public class CheckCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 浏览器不能缓存验证码 Cache-Control: no-cache
        response.setHeader("Cache-Control", "no-store, no-cache, max-age=0, must-revalidate, proxy-revalidate");
        OutputStream os = response.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        request.getSession().setAttribute("checkCode", checkCode);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
