package cn.icexmoon.logindemo.mapper;

import cn.icexmoon.logindemo.entity.Brand;
import cn.icexmoon.logindemo.util.MyBatisUtil;
import cn.icexmoon.logindemo.util.TwoTuple;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.mapper
 * @ClassName : .javab
 * @createTime : 2023/9/10 13:15
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class BrandMapperTests {
    @Test
    public void testSelectAll(){
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        brands.forEach(System.out::println);
    }
}
