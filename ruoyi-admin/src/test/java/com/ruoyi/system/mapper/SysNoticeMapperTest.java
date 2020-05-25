package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysNotice;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:08:26
 */
public class SysNoticeMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysNoticeMapper sysNoticeMapper;


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

        SysNotice entity = new SysNotice();
        entity.setNoticeId(longTestId);
        entity.setNoticeTitle("test");
        entity.setNoticeType("1");
        entity.setNoticeContent("test");
        entity.setStatus("1");
        entity.setRemark("test");

        int insert = sysNoticeMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysNotice sysConfig = sysNoticeMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysNotice> queryWrapper = new QueryWrapper<SysNotice>().lambda();
        queryWrapper.eq(SysNotice::getNoticeId, longTestId);
        SysNotice sysConfig = sysNoticeMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setNoticeContent("KEY");
        int i = sysNoticeMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysNotice sysConfig2 = sysNoticeMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getNoticeContent(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysNoticeMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}