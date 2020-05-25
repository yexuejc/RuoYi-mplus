package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysUserPost;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:53
 */
public class SysUserPostMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysUserPostMapper sysUserPostMapper;


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
        SysUserPost entity = new SysUserPost();
        entity.setUserId(longTestId);
        entity.setPostId(longTestId);

        int insert = sysUserPostMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysUserPost sysConfig = sysUserPostMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysUserPost> queryWrapper = new QueryWrapper<SysUserPost>().lambda();
        queryWrapper.eq(SysUserPost::getUserId, longTestId);
        SysUserPost sysConfig = sysUserPostMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setPostId(longTestId2);
        int i = sysUserPostMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysUserPost sysConfig2 = sysUserPostMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getPostId(), new Long(longTestId2));
    }

    @Override
    public void delete() {
        int i = sysUserPostMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}