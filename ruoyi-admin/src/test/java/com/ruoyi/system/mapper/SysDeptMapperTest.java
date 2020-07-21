package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysConfig;
import com.ruoyi.system.domain.SysDept;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author: yexuejc
 * @date: 2020-05-25 14:39:55
 */
public class SysDeptMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysDeptMapper sysDeptMapper;


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

        SysDept entity = new SysDept();
        entity.setDeptId(longTestId);
        entity.setParentId(longTestId);
        entity.setAncestors("test");
        entity.setDeptName("test");
        entity.setOrderNum(0);
        entity.setLeader("test");
        entity.setPhone("test");
        entity.setEmail("test");
        entity.setStatus("0");
        entity.setDelFlag("0");


        int insert = sysDeptMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysDept sysConfig = sysDeptMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysDept> queryWrapper = new QueryWrapper<SysDept>().lambda();
        queryWrapper.eq(SysDept::getDeptId, longTestId);
        SysDept sysConfig = sysDeptMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setAncestors("KEY");
        int i = sysDeptMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysDept sysConfig2 = sysDeptMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getAncestors(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysDeptMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}