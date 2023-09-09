package cn.icexmoon.webdemo.forward; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : web-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/9 16:31
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/forward/b")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("B servlet handling ...");
        Object time = request.getAttribute("time");
        if (time instanceof LocalDateTime) {
            LocalDateTime datetime = (LocalDateTime) time;
            System.out.println("time: "+datetime.format(DateTimeFormatter.ISO_DATE_TIME));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
