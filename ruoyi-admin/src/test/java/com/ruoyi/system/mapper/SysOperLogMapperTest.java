package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysOperLog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:08:38
 */
public class SysOperLogMapperTest  extends BaseTest implements IMapperTest {

    @Autowired
    SysOperLogMapper sysOperLogMapper;


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

        SysOperLog entity = new SysOperLog();
        entity.setOperId(longTestId);
        entity.setTitle("test");
        entity.setBusinessType(1);
        entity.setMethod("test");
        entity.setRequestMethod("test");
        entity.setOperatorType(1);
        entity.setOperName("test");
        entity.setDeptName("test");
        entity.setOperUrl("test");
        entity.setOperIp("test");
        entity.setOperLocation("test");
        entity.setOperParam("test");
        entity.setJsonResult("test");
        entity.setStatus(0);
        entity.setErrorMsg("test");
        entity.setOperTime(new Date());

        entity.setRemark("test");

        int insert = sysOperLogMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysOperLog sysConfig = sysOperLogMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<SysOperLog>().lambda();
        queryWrapper.eq(SysOperLog::getOperId, longTestId);
        SysOperLog sysConfig = sysOperLogMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setErrorMsg("KEY");
        int i = sysOperLogMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysOperLog sysConfig2 = sysOperLogMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getErrorMsg(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysOperLogMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}