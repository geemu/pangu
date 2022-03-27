package com.github.geemu.generate;

import com.alibaba.fastjson.JSON;
import com.github.geemu.generate.entity.Cat;
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

    private static List<Cat> getCatInfo(Connection connection) throws SQLException {
        List<Cat> response = new ArrayList<>();
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet catalogSet = meta.getCatalogs();
        // 获取目录
        while (catalogSet.next()) {
            String catalog = catalogSet.getString("TABLE_CAT");
            if (StringUtils.isBlank(catalog)) {
                continue;
            }
            if (StringUtils.isBlank(connection.getCatalog()) || catalog.equals(connection.getCatalog())) {
                Cat cat = new Cat();
                cat.setName(catalog);
                response.add(cat);
            }
        }
        // 获取目录中的表
        for (Cat cat : response) {
            ResultSet tableSet = meta.getTables(cat.getName(), null, null, new String[]{"TABLE"});
            List<Table> tables = new ArrayList<>();
            while (tableSet.next()) {
                Table table = new Table();
                table.setName(tableSet.getString("TABLE_NAME"));
                table.setComment(tableSet.getString("REMARKS"));
                tables.add(table);
            }
            cat.setTables(tables);
        }
        // 获取表中的字段
        for (Cat cat : response) {
            for (int i = 0; i < cat.getTables().size(); i++) {
                for (Table table : cat.getTables()) {
                    ResultSet columnSet = meta.getColumns(cat.getName(), null, table.getName(), null);
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
