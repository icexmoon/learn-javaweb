package cn.icexmoon.logindemo.service.impl;

import cn.icexmoon.logindemo.dto.BrandQuery;
import cn.icexmoon.logindemo.dto.PageResult;
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

    @Override
    public List<Brand> query(Brand brand) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        List<Brand> brands = brandMapper.selectByCondition(brand, null);
        sqlSession.close();
        return brands;
    }

    @Override
    public PageResult<Brand> pageQuery(BrandQuery brandQuery) {
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
//        Integer begin = brandQuery.getPage().getLimitBegin();
//        Integer size = brandQuery.getPage().getLimitSize();
        List<Brand> brands = brandMapper.selectByCondition(brandQuery.getQuery(), brandQuery.getPage().getLimit());
        Integer total = brandMapper.selectCount(brandQuery.getQuery());
        PageResult.ResultPage resultPage = new PageResult.ResultPage(total, brandQuery.getPage().getCurrentPage(), brandQuery.getPage().getSize());
        PageResult<Brand> pageResult = new PageResult<>(brands, resultPage);
        sqlSession.close();
        return pageResult;
    }

    @Override
    public void batchDelete(int[] ids) {
        if (ids == null || ids.length == 0) {
            return;
        }
        TwoTuple<BrandMapper, SqlSession> tt = MyBatisUtil.getMapper(BrandMapper.class);
        BrandMapper brandMapper = tt.getA();
        SqlSession sqlSession = tt.getB();
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
