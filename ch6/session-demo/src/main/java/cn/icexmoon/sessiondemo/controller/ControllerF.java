package cn.icexmoon.sessiondemo.controller; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : session-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/12 11:59
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/f")
public class ControllerF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String msg = (String) session.getAttribute("msg");
        System.out.println("Msg in session: " + msg);
//        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
