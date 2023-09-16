package cn.icexmoon.logindemo.controller.brand; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : login-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/10 20:45
 * @version : 1.0
 * @author : 魔芋红茶
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */

import cn.icexmoon.logindemo.entity.Brand;
import cn.icexmoon.logindemo.service.BrandService;
import cn.icexmoon.logindemo.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brand/add")
public class AddController extends HttpServlet {
    private final BrandService brandService = new BrandServiceImpl();

    /**
     * 加载品牌添加页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/brand/add.jsp").forward(request, response);
    }

    /**
     * 添加品牌
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getReader().readLine();
        System.out.println(content);
        Brand brand = JSON.parseObject(content, Brand.class);
        brandService.addBrand(brand);
        response.getWriter().print("{\"result\":true}");
    }
}
