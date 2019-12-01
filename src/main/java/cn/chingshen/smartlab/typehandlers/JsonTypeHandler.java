package cn.chingshen.smartlab.typehandlers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Object.class)
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> tClass;

    public JsonTypeHandler(Class<T> tClass) {
        if (tClass == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.tClass = tClass;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, toString(t));
    }


    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return this.toObject(resultSet.getString(columnName), tClass);
    }


    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return this.toObject(resultSet.getString(columnIndex), tClass);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return this.toObject(callableStatement.getNString(columnIndex), tClass);
    }

    private String toString(T t) {
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private T toObject(String content, Class<T> tClass) {

        if (content != null || !content.isEmpty()) {
            try {
                return objectMapper.readValue(content, tClass);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_MISSING_VALUES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
