package com.github.geemu.generate;

import com.alibaba.fastjson.JSON;
import com.github.geemu.generate.entity.Catalog;
import com.github.geemu.generate.entity.Column;
import com.github.geemu.generate.entity.Table;
import com.github.geemu.generate.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 元数据提供者
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-26 20:12:16
 */
@Slf4j
public class Provider {

    private static List<Catalog> getCatInfo(Connection connection) throws SQLException {
        List<Catalog> response = new ArrayList<>();
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet catalogSet = meta.getCatalogs();
        // 获取目录
        while (catalogSet.next()) {
            String catalog = catalogSet.getString("TABLE_CAT");
            if (StringUtils.isBlank(catalog)) {
                continue;
            }
            if (StringUtils.isBlank(connection.getCatalog()) || catalog.equals(connection.getCatalog())) {
                Catalog cataLog = new Catalog();
                cataLog.setName(catalog);
                response.add(cataLog);
            }
        }
        // 获取目录中的表
        for (Catalog cataLog : response) {
            ResultSet tableSet = meta.getTables(cataLog.getName(), null, null, new String[]{"TABLE"});
            List<Table> tables = new ArrayList<>();
            while (tableSet.next()) {
                Table table = new Table();
                table.setName(tableSet.getString("TABLE_NAME"));
                table.setComment(tableSet.getString("REMARKS"));
                tables.add(table);
            }
            cataLog.setTables(tables);
        }
        // 获取表中的字段
        for (Catalog cataLog : response) {
            for (int i = 0; i < cataLog.getTables().size(); i++) {
                for (Table table : cataLog.getTables()) {
                    ResultSet columnSet = meta.getColumns(cataLog.getName(), null, table.getName(), null);
                    List<Column> columns = new ArrayList<>();
                    while (columnSet.next()) {
                        Column column = new Column();
                        column.setName(columnSet.getString("COLUMN_NAME"));
                        column.setJdbcType(JdbcType.forCode(columnSet.getInt("DATA_TYPE")));
                        column.setSize(columnSet.getInt("COLUMN_SIZE"));
                        column.setScale(columnSet.getInt("DECIMAL_DIGITS"));
                        column.setComment(columnSet.getString("REMARKS"));
                        column.setNullable(DatabaseMetaData.columnNoNulls != columnSet.getInt("NULLABLE"));
                        column.setDefaultValue(columnSet.getString("COLUMN_DEF"));
                        columns.add(column);
                    }
                    table.setColumns(columns);
                }
            }
        }
        return response;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true";
        String user = "root";
        String password = "Chen1436863821..";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(JSON.toJSONString(getCatInfo(connection)));
    }

}
