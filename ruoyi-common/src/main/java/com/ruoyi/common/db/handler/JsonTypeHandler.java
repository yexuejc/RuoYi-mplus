package com.ruoyi.common.db.handler;

import com.ruoyi.common.utils.JsonUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jsonb Object相互转化 TypeHandler
 *
 * @author maxf
 * @version 1.0
 * @ClassName JsonTypeHandler
 * @Description
 * @date 2018/12/12 15:10
 */
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null) {
            ps.setString(i, null);
        } else {
            ps.setString(i, JsonUtil.obj2Json(parameter));
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.getString(columnName) == null) {
            return null;
        }
        return JsonUtil.json2Obj(rs.getString(columnName), Object.class);
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.getString(columnIndex) == null) {
            return null;
        }
        return JsonUtil.json2Obj(rs.getString(columnIndex), Object.class);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.getString(columnIndex) == null) {
            return null;
        }
        return JsonUtil.json2Obj(cs.getString(columnIndex), Object.class);
    }

}
