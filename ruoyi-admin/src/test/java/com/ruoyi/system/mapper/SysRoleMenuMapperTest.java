package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.system.BaseTest;
import com.ruoyi.system.IMapperTest;
import com.ruoyi.system.domain.SysRoleMenu;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: yexuejc
 * @date: 2020-05-25 15:09:25
 */
public class SysRoleMenuMapperTest extends BaseTest implements IMapperTest {

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;


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
        SysRoleMenu entity = new SysRoleMenu();
        entity.setRoleId(longTestId);
        entity.setMenuId(longTestId);

        int insert = sysRoleMenuMapper.insert(entity);
        Assert.assertEquals(insert, 1);
    }

    @Override
    public void select() {
        SysRoleMenu sysConfig = sysRoleMenuMapper.selectById(longTestId);
        Assert.assertNotNull(sysConfig);
    }

    @Override
    public void update() {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = new QueryWrapper<SysRoleMenu>().lambda();
        queryWrapper.eq(SysRoleMenu::getMenuId, longTestId);
        SysRoleMenu sysConfig = sysRoleMenuMapper.selectOne(queryWrapper);
        Assert.assertNotNull(sysConfig);
        sysConfig.setMenuId(longTestId2);
        int i = sysRoleMenuMapper.updateById(sysConfig);
        Assert.assertEquals(i, 1);

        SysRoleMenu sysConfig2 = sysRoleMenuMapper.selectById(longTestId);
        Assert.assertEquals(sysConfig2.getMenuId(), new Long(longTestId2));
    }

    @Override
    public void delete() {
        int i = sysRoleMenuMapper.deleteById(longTestId);
        Assert.assertEquals(i, 1);
    }


}