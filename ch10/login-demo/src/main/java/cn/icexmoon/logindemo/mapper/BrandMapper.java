package cn.icexmoon.logindemo.mapper;

import cn.icexmoon.logindemo.entity.Brand;
import cn.icexmoon.logindemo.entity.Limit;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.mapper
 * @ClassName : .java
 * @createTime : 2023/9/10 13:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BrandMapper {
    @Select("select * from tb_brand;")
    List<Brand> selectAll();

    @Insert("insert into tb_brand(brand_name, company_name, ordered, description, status) VALUES (#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int insert(Brand brand);

    @Select("select * from tb_brand where id=#{id}")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);

    List<Brand> selectByCondition(@Param("brand") Brand brand, @Param("limit") Limit limit);

    void deleteByIds(@Param("ids") int[] ids);

    Integer selectCount(@Param("brand") Brand brand);
}
