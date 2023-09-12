package cn.icexmoon.logindemo.controller.brand; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : login-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/11 15:43
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import cn.icexmoon.logindemo.service.BrandService;
import cn.icexmoon.logindemo.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/brand/delete")
public class DeleteController extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    /**
     * 执行删除品牌操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        brandService.delBrand(Integer.valueOf(id));
        // 删除成功后重定向到列表页
        response.sendRedirect("/login-demo/brand/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
