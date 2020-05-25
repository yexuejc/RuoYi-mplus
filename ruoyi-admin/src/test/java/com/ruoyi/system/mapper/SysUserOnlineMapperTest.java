package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.enums.OnlineStatus;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysUserOnline;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:44
 */
public class SysUserOnlineMapperTest  extends BaseTest implements IMapperTest {

    @Autowired
    SysUserOnlineMapper sysUserOnlineMapper;


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
        SysUserOnline entity = new SysUserOnline();
        entity.setSessionId(testId);
        entity.setLoginName("test");
        entity.setDeptName("test");
        entity.setIpaddr("test");
        entity.setLoginLocation("test");
        entity.setBrowser("test");
        entity.setOs("test");
        entity.setStatus(OnlineStatus.on_line);
        entity.setStartTimestamp(new Date());
        entity.setLastAccessTime(new Date());
        entity.setExpireTime(10000L);

        entity.setRemark("test");

        int insert = sysUserOnlineMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysUserOnline sysConfig = sysUserOnlineMapper.selectById(testId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysUserOnline> queryWrapper = new QueryWrapper<SysUserOnline>().lambda();
        queryWrapper.eq(SysUserOnline::getSessionId, testId);
        SysUserOnline sysConfig = sysUserOnlineMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setLoginName("KEY");
        int i = sysUserOnlineMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysUserOnline sysConfig2 = sysUserOnlineMapper.selectById(testId);
        Assert.assertEquals(sysConfig2.getLoginName(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysUserOnlineMapper.deleteById(testId);
        Assert.assertEquals(i, 1);
    }


}