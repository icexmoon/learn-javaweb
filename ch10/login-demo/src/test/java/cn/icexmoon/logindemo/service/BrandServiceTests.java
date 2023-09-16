package cn.icexmoon.logindemo.service;

import cn.icexmoon.logindemo.dto.BrandQuery;
import cn.icexmoon.logindemo.dto.Page;
import cn.icexmoon.logindemo.dto.PageResult;
import cn.icexmoon.logindemo.entity.Brand;
import cn.icexmoon.logindemo.service.impl.BrandServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service
 * @ClassName : .java
 * @createTime : 2023/9/16 16:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class BrandServiceTests {
    private BrandService brandService = new BrandServiceImpl();

    @Test
    public void testQuery() {
        Brand brand = new Brand();
        brand.setStatus(1);
        List<Brand> brands = brandService.query(brand);
        System.out.println(brands);
    }

    @Test
    public void testPageQuery(){
        BrandQuery brandQuery = new BrandQuery();
        Brand brand = new Brand();
        brand.setStatus(0);
        brandQuery.setQuery(brand);
        brandQuery.setPage(new Page(1, 5));
        PageResult<Brand> brands = brandService.pageQuery(brandQuery);
        brands.getList().forEach(System.out::println);
    }
}
