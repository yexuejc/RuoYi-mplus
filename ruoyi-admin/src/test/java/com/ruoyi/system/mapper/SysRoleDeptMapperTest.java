package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysRoleDept;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:04
 */
public class SysRoleDeptMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysRoleDeptMapper sysRoleDeptMapper;


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

        SysRoleDept entity = new SysRoleDept();
        entity.setRoleId(longTestId);
        entity.setDeptId(longTestId);

        int insert = sysRoleDeptMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysRoleDept sysConfig = sysRoleDeptMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysRoleDept> queryWrapper = new QueryWrapper<SysRoleDept>().lambda();
        queryWrapper.eq(SysRoleDept::getDeptId, longTestId);
        SysRoleDept sysConfig = sysRoleDeptMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setDeptId(longTestId2);
        int i = sysRoleDeptMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysRoleDept sysConfig2 = sysRoleDeptMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getDeptId(), new Long(longTestId2));
    }

    @Override
    public void delete() {
        int i = sysRoleDeptMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}