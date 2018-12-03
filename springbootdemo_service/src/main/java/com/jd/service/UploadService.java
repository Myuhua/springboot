package com.jd.service;

import com.jd.entity.UploadBlockInputVo;
import com.jd.util.ReadFilePathProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Description: 根本点在于，由springboot注入后，框架会自己给我们将注入的实例中的属性进行初始化
 *                而通过自己new实例的方法，在new出来实例后，必须我们自己去给它做初始化，否则实例中的对象就有空的问题存在。
 *                如果想不通过框架给自动注入的方式而去调用实例，需要在自己new实例后自己去初始化set值，这样的话响应的问题就解决了。
 * @Author: yuhua
 * @Date: 2018/11/29
 */
@Service
public class UploadService {


    @Autowired
    /**
     *若要是改为new UploadService()进来这里，在未自己set初值的情况下会出现ReadFilePathProperties为null的问题。
     * 通过springboot注入进到这里，它会自动给初始化UploadService中的属性值，不会出现null的问题。
     */
    private ReadFilePathProperties readFilePathProperties;

    //

    /**
     * setReadFilePathProperties注释或保留说明：
     * 1.演示通过springboot注入方式去调用UploadService()中的方法需要注释掉（其实注释不注释掉不影响，为了对比注释掉）。
     * 2.演示通过new实例方式进入到UploadService去调用方法出现空指针问题，则需要注释掉这行代码（其实注释不注释掉不影响，为了对比注释掉）。
     * 3.演示通过new实例方式进入到UploadService去调用方法，通过在UploadService中set值解决问题，则这这部分代码需要保留。
     */
    public void setReadFilePathProperties(ReadFilePathProperties readFilePathProperties) {
        this.readFilePathProperties = readFilePathProperties;
    }
    /**
     * @Description: 文件写入方法
     * @param: [uploadBlockInputVo]
     * @return: void
     * @auther: yuhua
     * @date: 2018/11/29 15:01
     */
    public void uploadBlock(UploadBlockInputVo uploadBlockInputVo) {
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(uploadBlockInputVo.getBytes()));
        /**
         * 下面两行代码注释或保留说明：
         * 1.演示通过springboot注入方式去调用UploadService()中的方法需要注释掉（其实注释不注释掉不影响，为了对比注释掉）。
         * 2.演示通过new实例方式进入到UploadService去调用方法出现空指针问题，则需要注释掉这行代码。
         * 3.演示通过new实例方式进入到UploadService去调用方法，通过在UploadService中set值解决问题，则这行代码不能注释掉。
         */
        ReadFilePathProperties readFilePathProperties = new ReadFilePathProperties();
        setReadFilePathProperties(readFilePathProperties);
        /**
         * 这一句仅在演示用new实例调用时，被调用的实例方法中不包含需要初始化对象的情况下放开，而它下面的一句代码需要注释掉。
         */
//        String uploadPartPath = "D:\\\\myfile\\\\elasticsearch-6.4.2Zip";
        String uploadPartPath = readFilePathProperties.getPropertisInfo();
        System.out.println("写入地址:" + uploadPartPath);
        File file = new File(uploadPartPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(uploadPartPath, uploadBlockInputVo.getFileName());
        BufferedOutputStream bos = null;
        int position = 0;
        if (!file2.exists()) {
            try {
                bos = new BufferedOutputStream(new FileOutputStream(uploadPartPath + file.separator + uploadBlockInputVo.getFileName() + uploadBlockInputVo.getPartNumber() + uploadBlockInputVo.getSuffix()));
                byte[] bytes = new byte[uploadBlockInputVo.getLength()];  //通常1024的倍数
                int writeLen;
                while ((writeLen = bis.read(bytes)) != -1) {
                    bos.write(bytes, uploadBlockInputVo.getOffset(), writeLen);
                    if (writeLen != uploadBlockInputVo.getLength()) {
                        position = writeLen;
                    } else {
                        position = uploadBlockInputVo.getLength();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bis.close();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(position);
    }
}