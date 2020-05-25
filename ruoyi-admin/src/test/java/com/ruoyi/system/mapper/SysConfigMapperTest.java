package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-22 16:40:11
 */
public class SysConfigMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysConfigMapper sysConfigMapper;


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

        SysConfig entity = new SysConfig();
        entity.setConfigId(longTestId);
        entity.setConfigName("test");
        entity.setConfigKey("test");
        entity.setConfigValue("test");
        entity.setConfigType("0");
        int insert = sysConfigMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysConfig sysConfig = sysConfigMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysConfig> queryWrapper = new QueryWrapper<SysConfig>().lambda();
        queryWrapper.eq(SysConfig::getConfigId, longTestId);
        SysConfig sysConfig = sysConfigMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setConfigKey("KEY");
        int i = sysConfigMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysConfig sysConfig2 = sysConfigMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getConfigKey(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysConfigMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}