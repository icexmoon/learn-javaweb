package cn.icexmoon.logindemo.controller.brand;

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
 * @createTime : 2023/9/16 18:57
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@WebServlet("/brand/batchDelete")
public class BatchDeleteController extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getReader().readLine();
        int[] ids = JSON.parseObject(content, int[].class);
        brandService.batchDelete(ids);
    }
}
