package cn.icexmoon.mybatisdemo;

import cn.icexmoon.mybatisdemo.entity.Brand;
import cn.icexmoon.mybatisdemo.entity.User;
import cn.icexmoon.mybatisdemo.mapper.BrandMapper;
import cn.icexmoon.mybatisdemo.mapper.UserMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mybatis-demo
 * @Package : cn.icexmoon.mybatisdemo
 * @ClassName : .java
 * @createTime : 2023/8/22 15:03
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyBatisTest {
    private SqlSession sqlSession;

    @Before
    @SneakyThrows
    public void before() {
        //获取 SqlSessionFactory 对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取 SqlSession 对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        //释放资源
        sqlSession.close();
    }

    @Test
    @SneakyThrows
    public void testSelectAll() {
        //获取 Mapper 代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //使用 Mapper 代理对象执行 SQL
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
    }

    @Test
    public void testSelectOneById() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectOneById(1);
        System.out.println(brand);
    }

    @Test
    public void testSelectByConditions() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Map<String, Object> brand = new HashMap<>();
        brand.put("status", 1);
        brand.put("brandName", "小米");
        brand.put("companyName", "小米");
        List<Brand> brands = brandMapper.selectByConditions(brand);
        System.out.println(brands);
    }

    @Test
    public void testSelectByOneCondition() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        List<Brand> brands = brandMapper.selectByOneCondition(brand);
        System.out.println(brands);
    }

    @Test
    public void testSave() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setCompanyName("苹果");
        brand.setBrandName("apple");
        brand.setStatus(1);
        brand.setDescription("one more thing.");
        brand.setOrdered(1);
        brandMapper.save(brand);
        System.out.println(brand.getId());
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setId(8);
        brand.setBrandName("诺基亚");
        int lines = brandMapper.update(brand);
        System.out.println(lines);
        sqlSession.commit();
    }

    @Test
    public void testDeleteById(){
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteById(8);
        sqlSession.commit();
    }

    @Test
    public void testDeleteByIds(){
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(new int[]{7,9,10});
        sqlSession.commit();
    }

    @Test
    public void testSelectUserById(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
