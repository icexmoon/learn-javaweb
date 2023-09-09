package cn.icexmoon.webdemo.response; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : web-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/9 17:44
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/response/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置报文头
        response.setHeader("Content-Type","image/png");
        // 读取一个本地文件
        File file = new File("D:/image/Screenshots/屏幕截图(27).png");
        InputStream inputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
