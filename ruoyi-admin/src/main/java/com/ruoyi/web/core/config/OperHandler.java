package com.ruoyi.web.core.config;

import com.ruoyi.common.config.MplusMetaObjectHandler;
import com.ruoyi.framework.util.ShiroUtils;


/**
 * 操作者
 *
 * @author yexuejc
 */
public class OperHandler extends MplusMetaObjectHandler {

    @Override
    protected Object getOperId() {
        try {
            return ShiroUtils.getLoginName();
        } catch (Exception e) {
            return "unknown";
        }
    }
}
