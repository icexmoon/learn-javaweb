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
import cn.icexmoon.logindemo.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
        Map<String, String> simpleUtf8Params = ServletUtil.getSimpleUtf8Params(request);
        String brandName = simpleUtf8Params.get("brandName");
        String companyName = simpleUtf8Params.get("companyName");
        String ordered = simpleUtf8Params.get("ordered");
        String description = simpleUtf8Params.get("description");
        String status = simpleUtf8Params.get("status");
        Brand brand = new Brand();
        brand.setBrandName(brandName)
                .setCompanyName(companyName)
                .setOrdered(Integer.valueOf(ordered))
                .setDescription(description)
                .setStatus(Integer.valueOf(status));
        brandService.addBrand(brand);
        //添加成功后让客户端重定向到列表页
        response.sendRedirect("/login-demo/brand/list");
    }
}
