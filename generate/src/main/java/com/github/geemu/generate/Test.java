package com.github.geemu.generate;

import com.alibaba.fastjson.JSON;
import com.github.geemu.generate.utils.FileUtils;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.github.geemu.generate
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-05-06 22:15:38
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String mysql = "jdbc:mysql://127.0.0.1:3306?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true";
        String user = "root";
        String password = "Chen1436863821..";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(mysql, user, password);
        System.out.println(JSON.toJSONString(Provider.getCatInfo(connection)));

        Map<String, Object> context = new HashMap<>(16);
        context.put("userName", "chenfangming");
        context.put("age", 11);
        RenderEngine.render("${userName}", context, "C:\\Users\\chenfangming\\Desktop\\a.txt");
        URL url = Test.class.getResource("/templates");
        if (null == url) {
            return;
        }
        String dir = url.getFile();
        List<File> files = FileUtils.getAllFile(dir);
        for (File file : files) {
            System.out.println(FileUtils.read(file));
        }
    }

}
