package com.ruoyi.common.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * 增加逻辑删除和乐观锁
 *
 * @author: yexuejc
 * @date: 2020-05-22 16:02:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BasePlusEntity extends BaseDO {

    /**
     * 逻辑删除
     */
    @TableField("is_del")
    @TableLogic(value = "false", delval = "true")
    private Boolean del = false;

    @TableField(value = "version", update = "%s+1", fill = FieldFill.INSERT_UPDATE)
    @Version
    private Long version;

    /**
     * 搜索值
     */
    @TableField(exist = false)
    private String searchValue;

    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }
}
