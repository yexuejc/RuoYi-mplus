package com.ruoyi.system;

import java.text.ParseException;

/**
 * 测试范围：基础增删改查
 *
 * @author maxf
 * @version 1.0
 * @ClassName BaseMapperTest
 * @Description
 * @date 2018/12/12 15:25
 */
public interface IMapperTest {
    /**
     * 增
     */
    void insert() throws ParseException;

    /**
     * 查
     */
    void select();

    /**
     * 改
     */
    void update();

    /**
     * 删
     */
    void delete();

}
