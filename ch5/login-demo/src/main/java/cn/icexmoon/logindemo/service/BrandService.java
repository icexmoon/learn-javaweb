package cn.icexmoon.logindemo.service;

import cn.icexmoon.logindemo.entity.Brand;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service
 * @ClassName : .java
 * @createTime : 2023/9/10 13:23
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BrandService {
    void addBrand(Brand brand);

    /**
     * 获取全部的品牌信息
     * @return
     */
    List<Brand> getAllBrands();

    Brand getBrandById(int intId);

    void update(Brand brand);

    void delBrand(int id);
}
