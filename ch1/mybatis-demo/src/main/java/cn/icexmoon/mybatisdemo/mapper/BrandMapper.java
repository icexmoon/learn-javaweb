package cn.icexmoon.mybatisdemo.mapper;

import cn.icexmoon.mybatisdemo.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mybatis-demo
 * @Package : cn.icexmoon.mybatisdemo.mapper
 * @ClassName : .java
 * @createTime : 2023/8/22 14:20
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectOneById(int id);

    List<Brand> selectByConditions(Map<String, Object> brand);

    List<Brand> selectByOneCondition(Brand brand);

    void save(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
