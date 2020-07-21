package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysMenu;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:08:05
 */
public class SysMenuMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysMenuMapper sysMenuMapper;


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

        SysMenu entity = new SysMenu();
        entity.setMenuId(longTestId);
        entity.setMenuName("test");
        entity.setParentId(longTestId);
        entity.setOrderNum(0);
        entity.setUrl("test");
        entity.setTarget("test");
        entity.setMenuType("1");
        entity.setVisible("0");
        entity.setPerms("test");
        entity.setIcon("test");

        int insert = sysMenuMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysMenu sysConfig = sysMenuMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysMenu> queryWrapper = new QueryWrapper<SysMenu>().lambda();
        queryWrapper.eq(SysMenu::getMenuId, longTestId);
        SysMenu sysConfig = sysMenuMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setMenuName("KEY");
        int i = sysMenuMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysMenu sysConfig2 = sysMenuMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getMenuName(), "KEY");
    }

    @Override
    public void delete() {
        int i = sysMenuMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}