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
 * 岗位信息表
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_post")
public class SysPost extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 备注
     */
    private String remark;

    /**
     * 岗位ID
     */
    @TableId(value = "post_id", type = IdType.ASSIGN_ID)
    private Long postId;

    /**
     * 岗位编码
     */
    @TableField("post_code")
    private String postCode;

    /**
     * 岗位名称
     */
    @TableField("post_name")
    private String postName;

    /**
     * 显示顺序
     */
    @TableField("post_sort")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    @TableField("status")
    private String status;


    /** 用户是否存在此岗位标识 默认不存在 */
    @TableField(exist = false)
    private boolean flag = false;

}
