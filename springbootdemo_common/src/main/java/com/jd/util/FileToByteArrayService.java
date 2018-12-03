
package com.jd.util;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description: 将文件转换为byte[]数组
 * @Author: yuhua
 * @Date: 2018/11/20
 */

@Service
public class FileToByteArrayService {
    public  byte[] fileToBytes(String fileSrc) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        byte[] bytes = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileSrc)));
            bytes = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedInputStream.close();
        }
        return bytes;
    }

}

