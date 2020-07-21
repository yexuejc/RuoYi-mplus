package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysDictData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 14:50:40
 */
public class SysDictDataMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysDictDataMapper sysDictDataMapper;


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

        SysDictData entity = new SysDictData();
        entity.setDictCode(longTestId);
        entity.setDictSort(0);
        entity.setDictLabel("text");
        entity.setDictValue("text");
        entity.setDictType("text");
        entity.setCssClass("text");
        entity.setListClass("text");
        entity.setIsDefault("Y");
        entity.setStatus("0");

        int insert = sysDictDataMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysDictData sysConfig = sysDictDataMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysDictData> queryWrapper = new QueryWrapper<SysDictData>().lambda();
        queryWrapper.eq(SysDictData::getDictCode, longTestId);
        SysDictData sysConfig = sysDictDataMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setDictValue("KEY");
        int i = sysDictDataMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysDictData sysConfig2 = sysDictDataMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getDictValue(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysDictDataMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}