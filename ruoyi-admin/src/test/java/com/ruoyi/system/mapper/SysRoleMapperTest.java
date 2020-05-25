package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysRole;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:16
 */
public class SysRoleMapperTest  extends BaseTest implements IMapperTest {

    @Autowired
    SysRoleMapper sysRoleMapper;


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

        SysRole entity = new SysRole();
        entity.setRoleId(longTestId);
        entity.setRoleName("test");
        entity.setRoleKey("test");
        entity.setRoleSort(1);
        entity.setDataScope("1");
        entity.setStatus("1");
        entity.setDelFlag("1");

        entity.setRemark("test");

        int insert = sysRoleMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysRole sysConfig = sysRoleMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>().lambda();
        queryWrapper.eq(SysRole::getRoleId, longTestId);
        SysRole sysConfig = sysRoleMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setRoleKey("KEY");
        int i = sysRoleMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysRole sysConfig2 = sysRoleMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getRoleKey(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysRoleMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}