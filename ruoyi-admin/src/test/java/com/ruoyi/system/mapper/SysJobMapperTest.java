package com.ruoyi.system.mapper;

import com.ruoyi.quartz.domain.SysJob;
import com.ruoyi.quartz.mapper.SysJobMapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-22 16:11:44
 */
public class SysJobMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysJobMapper sysJobMapper;


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

        SysJob entity = new SysJob();
        entity.setJobId(longTestId);
        entity.setJobName("test");
        entity.setJobGroup("test");
        entity.setInvokeTarget("test");
        entity.setCronExpression("test");
        entity.setMisfirePolicy("test");
        entity.setConcurrent("0");
        entity.setStatus("S");

        int insert = sysJobMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysJob sysLog = sysJobMapper.selectById(longTestId);
        Assert.assertNotNull(sysLog);
    }

    @Override
    public void update() {
        SysJob entity = sysJobMapper.selectById(longTestId);
        Assert.assertNotNull(entity);
        entity.setStatus("F");
        int i = sysJobMapper.updateById(entity);
        Assert.assertEquals(i, 1);

        SysJob entity2 = sysJobMapper.selectById(longTestId);
        Assert.assertEquals(entity2.getStatus(), "F");
    }

    @Override
    public void delete() {
        int i = sysJobMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }

    @Test
    public void selectJobList() {
    }

    @Test
    public void selectJobAll() {
    }

    @Test
    public void selectJobById() {
    }

    @Test
    public void deleteJobById() {
    }

    @Test
    public void deleteJobByIds() {
    }

    @Test
    public void updateJob() {
    }

    @Test
    public void insertJob() {
    }
}