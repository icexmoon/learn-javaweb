package cn.icexmoon.logindemo.service;

import cn.icexmoon.logindemo.dto.BrandQuery;
import cn.icexmoon.logindemo.dto.PageResult;
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
     *
     * @return
     */
    List<Brand> getAllBrands();

    Brand getBrandById(int intId);

    void update(Brand brand);

    void delBrand(int id);

    /**
     * 查询品牌列表
     *
     * @param brand 品牌信息
     * @return 符合条件的品牌列表
     */
    List<Brand> query(Brand brand);

    /**
     * 分页查询品牌列表
     *
     * @param brandQuery 查询条件
     * @return
     */
    PageResult<Brand> pageQuery(BrandQuery brandQuery);

    /**
     * 批量删除品牌
     *
     * @param ids 品牌id序列
     */
    void batchDelete(int[] ids);
}
