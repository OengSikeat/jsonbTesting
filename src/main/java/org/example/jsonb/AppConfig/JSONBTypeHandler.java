package org.example.jsonb.AppConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.jsonb.model.ImageData;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@MappedTypes(Map.class)
public class JSONBTypeHandler extends BaseTypeHandler<Map<String, ImageData>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, ImageData> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setObject(i, objectMapper.writeValueAsString(parameter), Types.OTHER);
        } catch (JsonProcessingException e) {
            throw new SQLException("Error serializing JSON", e);
        }
    }

    @Override
    public Map<String, ImageData> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);
        if (json == null) return null;
        try {
            Map<String, Map<String, Object>> temp = objectMapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<Map<String, Map<String, Object>>>() {});
            Map<String, ImageData> result = new HashMap<>();
            for (Map.Entry<String, Map<String, Object>> entry : temp.entrySet()) {
                result.put(entry.getKey(), objectMapper.convertValue(entry.getValue(), ImageData.class));
            }
            return result;
        } catch (JsonProcessingException e) {
            throw new SQLException("Error deserializing JSON", e);
        }
    }

    @Override
    public Map<String, ImageData> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getNullableResult(rs, rs.getMetaData().getColumnName(columnIndex));
    }

    @Override
    public Map<String, ImageData> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getNullableResult(cs, columnIndex);
    }
}


