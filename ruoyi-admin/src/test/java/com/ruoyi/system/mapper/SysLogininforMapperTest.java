package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysLogininfor;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:07:50
 */
public class SysLogininforMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysLogininforMapper sysLogininforMapper;


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

        SysLogininfor entity = new SysLogininfor();
        entity.setInfoId(longTestId);
        entity.setLoginName("1");
        entity.setIpaddr("1");
        entity.setLoginLocation("1");
        entity.setBrowser("1");
        entity.setOs("1");
        entity.setStatus("1");
        entity.setMsg("1");
        entity.setLoginTime(new Date());

        entity.setRemark("1");

        int insert = sysLogininforMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysLogininfor sysConfig = sysLogininforMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysLogininfor> queryWrapper = new QueryWrapper<SysLogininfor>().lambda();
        queryWrapper.eq(SysLogininfor::getInfoId, longTestId);
        SysLogininfor sysConfig = sysLogininforMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setBrowser("KEY");
        int i = sysLogininforMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysLogininfor sysConfig2 = sysLogininforMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getBrowser(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysLogininforMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}