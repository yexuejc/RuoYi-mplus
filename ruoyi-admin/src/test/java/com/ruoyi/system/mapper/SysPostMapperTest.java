package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysPost;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:08:52
 */
public class SysPostMapperTest  extends BaseTest implements IMapperTest {

    @Autowired
    SysPostMapper sysPostMapper;


    @Test
    @Transactional
    @Rollback
    public void testRun() {
        insert();
        select();
        update();
        delete();
    }

    @Override
    public void insert() {

        SysPost entity = new SysPost();
        entity.setPostId(longTestId);
        entity.setPostCode("test");
        entity.setPostName("test");
        entity.setPostSort(0);
        entity.setStatus("1");

        entity.setRemark("test");

        int insert = sysPostMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysPost sysConfig = sysPostMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysPost> queryWrapper = new QueryWrapper<SysPost>().lambda();
        queryWrapper.eq(SysPost::getPostId, longTestId);
        SysPost sysConfig = sysPostMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setPostName("KEY");
        int i = sysPostMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysPost sysConfig2 = sysPostMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getPostName(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysPostMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}