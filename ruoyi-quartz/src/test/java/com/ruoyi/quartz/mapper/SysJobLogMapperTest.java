package com.ruoyi.quartz.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.quartz.BaseTest;
import com.ruoyi.quartz.IMapperTest;
import com.ruoyi.quartz.domain.SysJobLog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: yexuejc
 * @date: 2020-05-22 15:07:22
 */
public class SysJobLogMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysJobLogMapper sysJobLogMapper;


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
        SysJobLog entity = new SysJobLog();
        entity.setJobLogId(longTestId);
        entity.setJobName("test");
        entity.setJobGroup("test");
        entity.setInvokeTarget("test");
        entity.setJobMessage("test");
        entity.setStatus("S");
        entity.setExceptionInfo("test");
        entity.setStartTime(new Date());
        entity.setEndTime(new Date());
        int insert = sysJobLogMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysJobLog sysJobLog = sysJobLogMapper.selectById(longTestId);
        Assert.assertNotNull(sysJobLog);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysJobLog> queryWrapper = new QueryWrapper<SysJobLog>().lambda();
        queryWrapper.eq(SysJobLog::getJobLogId, longTestId);
        SysJobLog sysJobLog = sysJobLogMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysJobLog);
        sysJobLog.setStatus("F");
        int i = sysJobLogMapper.updateById(sysJobLog);
        Assert.assertEquals(i, 1);

        SysJobLog sysJobLog2 = sysJobLogMapper.selectJobLogById(longTestId);
        Assert.assertEquals(sysJobLog2.getStatus(), "F");
    }

    @Override
    public void delete() {
        int i = sysJobLogMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


    @Test
    public void selectJobLogList() {
    }

    @Test
    public void selectJobLogAll() {
    }

    @Test
    public void selectJobLogById() {
    }

    @Test
    public void insertJobLog() {
    }

    @Test
    public void deleteJobLogByIds() {
    }

    @Test
    public void deleteJobLogById() {
    }

    @Test
    public void cleanJobLog() {
    }


}