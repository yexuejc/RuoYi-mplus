package com.ruoyi.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 注入公共字段自动填充,任选注入方式即可
 * <h2>
 * 继承使用
 * </h2>
 * <p>
 * 继承后<i>重写 {@link #getOperId()}</i> 和 <i>重新注入 Bean</i>
 * </p>
 * <pre>
 *     @author yexuejc
 * @Bean
 *     public MyMetaObjectHandler metaObjectHandler() {
 *         return new MyMetaObjectHandler();
 *     }
 * </pre>
 */
public class MplusMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建时间
     */
    protected String crtTimeColumn = "createTime";
    /**
     * 创建人
     */
    protected String crtByColumn = "createBy";
    /**
     * 最后操作时间
     */
    protected String updateTimeColumn = "updateTime";
    /**
     * 最后操作人
     */
    protected String updateByColumn = "updateBy";

    /**
     * 设置操作者
     * <p>
     * 应设置登录账号为操作者，这里由每个工程具体实现
     * </p>
     * <p>
     * 返回null时，会查找consumerId作为操作者，找不到会设置默认值
     * <br/>
     * 返回"" 时，会存""
     * </p>
     *
     * @return
     */
    protected Object getOperId() {
        return null;
    }


    @Override
    public void insertFill(MetaObject metaObject) {
//        LogUtil.bizLogger.debug("新增的时候干点不可描述的事情");
        try {
            //创建人和创建时间
            Object crtTime = metaObject.getValue(crtTimeColumn);
            if (crtTime == null) {
                metaObject.setValue(crtTimeColumn, new Date());
            }
            Object crtBy = metaObject.getValue(crtByColumn);
            if (crtBy == null) {
                Object operId = null;
                try {
                    operId = getOperId();
                    if (operId == null) {
                        operId = metaObject.getValue("userId");
                    }
                } catch (Exception e) {
                } finally {
                    if (operId != null) {
                        metaObject.setValue(crtByColumn, operId);
                    } else {
                        metaObject.setValue(crtByColumn, "mp-insert");
                    }
                }
            }

            //修改人和修改建时间
            Object mdfyTime = metaObject.getValue(updateTimeColumn);
            if (mdfyTime == null) {
                metaObject.setValue(updateTimeColumn, new Date());
            }

            Object mdfyBy = metaObject.getValue(updateByColumn);
            if (mdfyBy == null) {
                Object operId = null;
                try {
                    operId = getOperId();
                    if (operId == null) {
                        operId = metaObject.getValue("userId");
                    }
                } catch (Exception e) {

                } finally {
                    if (operId != null) {
                        metaObject.setValue(updateByColumn, operId);
                    } else {
                        metaObject.setValue(updateByColumn, "mp-insert");
                    }
                }
            }
        } catch (Exception e) {
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
//        LogUtil.bizLogger.debug("更新的时候干点不可描述的事情");
        try {
            Object mdfyTime = this.getFieldValByName(updateTimeColumn, metaObject);
            if (mdfyTime == null) {
                this.setFieldValByName(updateTimeColumn, new Date(), metaObject);
            }
            Object crtBy = this.getFieldValByName(updateByColumn, metaObject);
            if (crtBy == null) {
                Object operId = null;
                try {
                    operId = getOperId();
                    if (operId == null) {
                        operId = this.getFieldValByName("userId", metaObject);
                    }
                } catch (Exception e) {

                } finally {
                    if (operId != null) {
                        this.setFieldValByName(updateByColumn, operId, metaObject);
                    } else {
                        this.setFieldValByName(updateByColumn, "mp-update", metaObject);
                    }
                }
            }
        } catch (Exception e) {

        }
    }

}
