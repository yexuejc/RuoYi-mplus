package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysDictType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 14:54:25
 */
public class SysDictTypeMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysDictTypeMapper sysDictTypeMapper;


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
        SysDictType entity = new SysDictType();
        entity.setDictId(longTestId);
        entity.setDictName("text");
        entity.setDictType("0");
        entity.setStatus("0");


        int insert = sysDictTypeMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysDictType sysConfig = sysDictTypeMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysDictType> queryWrapper = new QueryWrapper<SysDictType>().lambda();
        queryWrapper.eq(SysDictType::getDictId, longTestId);
        SysDictType sysConfig = sysDictTypeMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setDictName("KEY");
        int i = sysDictTypeMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysDictType sysConfig2 = sysDictTypeMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getDictName(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysDictTypeMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}