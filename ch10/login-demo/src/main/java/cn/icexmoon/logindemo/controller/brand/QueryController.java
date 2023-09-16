package cn.icexmoon.logindemo.controller.brand;

import cn.icexmoon.logindemo.dto.BrandQuery;
import cn.icexmoon.logindemo.dto.PageResult;
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

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.controller.brand
 * @ClassName : .java
 * @createTime : 2023/9/16 16:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 查询品牌列表
 */
@WebServlet("/brand/query")
public class QueryController extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getReader().readLine();
        BrandQuery brand = JSON.parseObject(content, BrandQuery.class);
        PageResult<Brand> pageResult = brandService.pageQuery(brand);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().print(JSON.toJSONString(pageResult));
    }
}
