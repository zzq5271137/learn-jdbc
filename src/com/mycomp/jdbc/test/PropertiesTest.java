package com.mycomp.jdbc.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * 读取配置文件
 */

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("resource/db.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("driverClassName"));
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
