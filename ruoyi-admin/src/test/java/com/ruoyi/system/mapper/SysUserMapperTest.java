package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:35
 */
public class SysUserMapperTest  extends BaseTest implements IMapperTest {

    @Autowired
    SysUserMapper sysUserMapper;


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

        SysUser entity = new SysUser();
        entity.setUserId(longTestId);
        entity.setDeptId(longTestId);
        entity.setLoginName("test");
        entity.setUserName("test");
        entity.setUserType("1");
        entity.setEmail("test");
        entity.setPhonenumber("test");
        entity.setSex("1");
        entity.setAvatar("test");
        entity.setPassword("test");
        entity.setSalt("test");
        entity.setStatus("1");
        entity.setDelFlag("1");
        entity.setLoginIp("test");
        entity.setLoginDate(new Date());

        entity.setRemark("test");

        int insert = sysUserMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysUser sysConfig = sysUserMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        queryWrapper.eq(SysUser::getUserId, longTestId);
        SysUser sysConfig = sysUserMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setAvatar("KEY");
        int i = sysUserMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysUser sysConfig2 = sysUserMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getAvatar(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysUserMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}