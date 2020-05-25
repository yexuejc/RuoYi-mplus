package com.ruoyi.framework.config;

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
    protected String CRT_TIME_CLO = "crtTime";
    /**
     * 创建人
     */
    protected String CRT_BY_CLO = "crtBy";
    /**
     * 最后操作时间
     */
    protected String UPDATE_TIME_CLO = "mdfyTime";
    /**
     * 最后操作人
     */
    protected String UPDATE_BY_CLO = "mdfyBy";

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
            Object crtTime = metaObject.getValue(CRT_TIME_CLO);
            if (crtTime == null) {
                metaObject.setValue(CRT_TIME_CLO, new Date());
            }
            Object crtBy = metaObject.getValue(CRT_BY_CLO);
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
                        metaObject.setValue(CRT_BY_CLO, operId);
                    } else {
                        metaObject.setValue(CRT_BY_CLO, "mp-insert");
                    }
                }
            }

            //修改人和修改建时间
            Object mdfyTime = metaObject.getValue(UPDATE_TIME_CLO);
            if (mdfyTime == null) {
                metaObject.setValue(UPDATE_TIME_CLO, new Date());
            }

            Object mdfyBy = metaObject.getValue(UPDATE_BY_CLO);
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
                        metaObject.setValue(UPDATE_BY_CLO, operId);
                    } else {
                        metaObject.setValue(UPDATE_BY_CLO, "mp-insert");
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
            Object mdfyTime = this.getFieldValByName("mdfyTime", metaObject);
            if (mdfyTime == null) {
                this.setFieldValByName("mdfyTime", new Date(), metaObject);
            }
            Object crtBy = this.getFieldValByName("mdfyBy", metaObject);
            if (crtBy == null) {
                Object operId = null;
                try {
                    operId = getOperId();
                    if (operId == null) {
                        operId = this.getFieldValByName("mchId", metaObject);
                    }
                } catch (Exception e) {

                } finally {
                    if (operId != null) {
                        this.setFieldValByName("mdfyBy", operId, metaObject);
                    } else {
                        this.setFieldValByName("mdfyBy", "mp-update", metaObject);
                    }
                }
            }
        } catch (Exception e) {

        }
    }


}
