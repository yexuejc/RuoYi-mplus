package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_type")
public class SysDictType extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 备注
     */
    private String remark;

    /**
     * 字典主键
     */
    @TableId(value = "dict_id", type = IdType.ASSIGN_ID)
    private Long dictId;

    /**
     * 字典名称
     */
    @TableField("dict_name")
    private String dictName;

    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    @TableField("status")
    private String status;


}
