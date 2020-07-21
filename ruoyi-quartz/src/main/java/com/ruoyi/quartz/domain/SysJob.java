package com.ruoyi.quartz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.ruoyi.common.core.domain.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 定时任务调度表
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_job")
public class SysJob extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 备注
     */
    private String remark;

    /**
     * 任务ID
     */
    @TableId(value = "job_id", type = IdType.ASSIGN_ID)
    private Long jobId;

    /**
     * 任务名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * 任务组名
     */
    @TableField("job_group")
    private String jobGroup;

    /**
     * 调用目标字符串
     */
    @TableField("invoke_target")
    private String invokeTarget;

    /**
     * cron执行表达式
     */
    @TableField("cron_expression")
    private String cronExpression;

    /**
     * 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    @TableField("misfire_policy")
    private String misfirePolicy;

    /**
     * 是否并发执行（0允许 1禁止）
     */
    @TableField("concurrent")
    private String concurrent;

    /**
     * 状态（0正常 1暂停）
     */
    @TableField("status")
    private String status;


}
