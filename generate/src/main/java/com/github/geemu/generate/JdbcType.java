package com.github.geemu.generate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * com.github.geemu.generate
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-27 16:53:09
 */
@Getter
@AllArgsConstructor
public enum JdbcType {

    /** 数组 **/
    ARRAY(Types.ARRAY),
    BIT(Types.BIT),
    TINYINT(Types.TINYINT),
    SMALLINT(Types.SMALLINT),
    INTEGER(Types.INTEGER),
    BIGINT(Types.BIGINT),
    FLOAT(Types.FLOAT),
    REAL(Types.REAL),
    DOUBLE(Types.DOUBLE),
    NUMERIC(Types.NUMERIC),
    DECIMAL(Types.DECIMAL),
    CHAR(Types.CHAR),
    VARCHAR(Types.VARCHAR),
    LONG_VARCHAR(Types.LONGVARCHAR),
    DATE(Types.DATE),
    TIME(Types.TIME),
    TIMESTAMP(Types.TIMESTAMP),
    BINARY(Types.BINARY),
    VARBINARY(Types.VARBINARY),
    LONG_VAR_BINARY(Types.LONGVARBINARY),
    NULL(Types.NULL),
    OTHER(Types.OTHER),
    BLOB(Types.BLOB),
    CLOB(Types.CLOB),
    BOOLEAN(Types.BOOLEAN),
    CURSOR(-10),
    UNDEFINED(Integer.MIN_VALUE + 1000),
    NVARCHAR(Types.NVARCHAR),
    NCHAR(Types.NCHAR),
    NCLOB(Types.NCLOB),
    STRUCT(Types.STRUCT),
    JAVA_OBJECT(Types.JAVA_OBJECT),
    DISTINCT(Types.DISTINCT),
    REF(Types.REF),
    DATA_LINK(Types.DATALINK),
    ROWID(Types.ROWID),
    LONG_NVARCHAR(Types.LONGNVARCHAR),
    SQL_XML(Types.SQLXML),
    DATETIME_OFFSET(-155),
    TIME_WITH_TIMEZONE(Types.TIME_WITH_TIMEZONE),
    TIMESTAMP_WITH_TIMEZONE(Types.TIMESTAMP_WITH_TIMEZONE);

    public final int TYPE_CODE;
    private static Map<Integer,JdbcType> CODE_LOOKUP = new HashMap<>();

    static {
        for (JdbcType type : JdbcType.values()) {
            CODE_LOOKUP.put(type.TYPE_CODE, type);
        }
    }

    public static JdbcType forCode(int code)  {
        return CODE_LOOKUP.get(code);
    }

}
