package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysUserRole;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:10:03
 */
public class SysUserRoleMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;


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

        SysUserRole entity = new SysUserRole();
        entity.setUserId(longTestId);
        entity.setRoleId(longTestId);

        int insert = sysUserRoleMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysUserRole sysConfig = sysUserRoleMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<SysUserRole>().lambda();
        queryWrapper.eq(SysUserRole::getRoleId, longTestId);
        SysUserRole sysConfig = sysUserRoleMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setRoleId(longTestId2);
        int i = sysUserRoleMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysUserRole sysConfig2 = sysUserRoleMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getRoleId(), new Long(longTestId2));
    }

    @Override
    public void delete() {
        int i = sysUserRoleMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}