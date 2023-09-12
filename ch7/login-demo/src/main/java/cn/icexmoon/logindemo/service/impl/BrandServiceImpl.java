package cn.icexmoon.logindemo.service.impl;

import cn.icexmoon.logindemo.entity.Brand;
import cn.icexmoon.logindemo.mapper.BrandMapper;
import cn.icexmoon.logindemo.service.BrandService;
import cn.icexmoon.logindemo.util.MyBatisUtil;
import cn.icexmoon.logindemo.util.TwoTuple;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : login-demo
 * @Package : cn.icexmoon.logindemo.service.impl
 * @ClassName : .java
 * @createTime : 2023/9/10 13:24
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class BrandServiceImpl implements BrandService {

    @Override
    public void addBrand(Brand brand) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        brandMapper.insert(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Brand> getAllBrands() {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public Brand getBrandById(int id) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    @Override
    public void update(Brand brand) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delBrand(int id) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
