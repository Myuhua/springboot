package com.jd.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: 将文件随机选择路径存放
 * @Author: yuhua
 * @Date: 2018/11/20
 */
@Component
public class ReadFilePathProperties {
    public String getPropertisInfo() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("file.properties");
        String[] keywords = {"UPLOAD_PATH", "UPLOAD_PATH1","UPLOAD_PATH2"};
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String property = p.getProperty(keywords[(int) (Math.random() * keywords.length)]);
        return property;
    }
}
