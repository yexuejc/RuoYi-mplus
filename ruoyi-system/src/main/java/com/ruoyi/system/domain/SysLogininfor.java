package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_logininfor")
public class SysLogininfor extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 访问ID
     */
    @TableId(value = "info_id", type = IdType.ASSIGN_ID)
    private Long infoId;

    /**
     * 登录账号
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 登录IP地址
     */
    @TableField("ipaddr")
    private String ipaddr;

    /**
     * 登录地点
     */
    @TableField("login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    @TableField("browser")
    private String browser;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 登录状态（0成功 1失败）
     */
    @TableField("status")
    private String status;

    /**
     * 提示消息
     */
    @TableField("msg")
    private String msg;

    /**
     * 访问时间
     */
    @TableField("login_time")
    private Date loginTime;


}
