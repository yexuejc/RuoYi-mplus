package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author yexuejc
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_oper_log")
public class SysOperLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @TableId(value = "oper_id", type = IdType.ASSIGN_ID)
    @Excel(name = "操作序号", cellType = Excel.ColumnType.NUMERIC)
    private Long operId;

    /**
     * 模块标题
     */
    @TableField("title")
    @Excel(name = "操作模块")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @TableField("business_type")
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer businessType;

    /** 业务类型数组 */
    @TableField(exist = false)
    private Integer[] businessTypes;
    /**
     * 方法名称
     */
    @TableField("method")
    @Excel(name = "请求方法")
    private String method;

    /**
     * 请求方式
     */
    @TableField("request_method")
    @Excel(name = "请求方式")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @TableField("operator_type")
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Integer operatorType;

    /**
     * 操作人员
     */
    @TableField("oper_name")
    @Excel(name = "操作人员")
    private String operName;

    /**
     * 部门名称
     */
    @TableField("dept_name")
    @Excel(name = "部门名称")
    private String deptName;

    /**
     * 请求URL
     */
    @TableField("oper_url")
    @Excel(name = "请求地址")
    private String operUrl;

    /**
     * 主机地址
     */
    @TableField("oper_ip")
    @Excel(name = "操作地址")
    private String operIp;

    /**
     * 操作地点
     */
    @TableField("oper_location")
    @Excel(name = "操作地点")
    private String operLocation;

    /**
     * 请求参数
     */
    @TableField("oper_param")
    @Excel(name = "请求参数")
    private String operParam;

    /**
     * 返回参数
     */
    @TableField("json_result")
    @Excel(name = "返回参数")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @TableField("status")
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer status;

    /**
     * 错误消息
     */
    @TableField("error_msg")
    @Excel(name = "错误消息")
    private String errorMsg;

    /**
     * 操作时间
     */
    @TableField("oper_time")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;


}
