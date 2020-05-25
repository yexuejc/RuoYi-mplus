package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.OnlineStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 在线用户记录
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user_online")
public class SysUserOnline extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户会话id
     */
    @TableId(value = "sessionId", type = IdType.ASSIGN_ID)
    private String sessionId;

    /**
     * 登录账号
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;

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
     * 在线状态on_line在线off_line离线
     */
    @TableField("status")
    private OnlineStatus status = OnlineStatus.on_line;

    /**
     * session创建时间
     */
    @TableField("start_timestamp")
    private Date startTimestamp;

    /**
     * session最后访问时间
     */
    @TableField("last_access_time")
    private Date lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    @TableField("expire_time")
    private Long expireTime;


}
