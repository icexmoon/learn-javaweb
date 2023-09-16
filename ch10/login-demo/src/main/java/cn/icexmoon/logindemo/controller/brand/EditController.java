package cn.icexmoon.logindemo.controller.brand; /**
 * Created with IntelliJ IDEA.
 *
 * @Project : login-demo
 * @Package : ${PACKAGE_NAME}
 * @ClassName : ${CLASS_NAME}.java
 * @createTime : 2023/9/10 21:43
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

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/brand/edit")
public class EditController extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();

    /**
     * 加载品牌编辑页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> simpleUtf8Params = ServletUtil.getSimpleUtf8Params(request);
        String id = simpleUtf8Params.get("id");
        Integer intId = Integer.valueOf(id);
        // 根据品牌 id 获取品牌信息
        Brand brand = brandService.getBrandById(intId);
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("/jsp/brand/edit.jsp").forward(request, response);
    }

    /**
     * 执行品牌编辑操作
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> simpleUtf8Params = ServletUtil.getSimpleUtf8Params(request);
        String id = simpleUtf8Params.get("id");
        String brandName = simpleUtf8Params.get("brandName");
        String companyName = simpleUtf8Params.get("companyName");
        String ordered = simpleUtf8Params.get("ordered");
        String description = simpleUtf8Params.get("description");
        String status = simpleUtf8Params.get("status");
        Brand brand = new Brand();
        brand.setId(Integer.valueOf(id))
                .setBrandName(brandName)
                .setCompanyName(companyName)
                .setOrdered(Integer.valueOf(ordered))
                .setDescription(description)
                .setStatus(Integer.valueOf(status));
        brandService.update(brand);
        // 修改成功后让客户端重定向到列表页
        response.sendRedirect("/login-demo/brand/list");
    }
}
