package com.jd.test;

import com.jd.SpringBootStart;
import com.jd.entity.UploadBlockInputVo;
import com.jd.service.UploadService;
import com.jd.util.FileToByteArrayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @Description: 这个类用来演示通过@Autowired自动注入与new实例的区别
 *  友情提示：
 *  1.为了方便我共用了这套框架，其他的Student* 相关的东西是用作他用的，大家不用去看。
 *  2.此次演示涉及到类 TestController/UploadService/FileToByteArrayService/ReadFilePathProperties
 *  这个演示demo是我从将来要跟大家分享的一个项目里拆出来修改后的，大家只关注前两个类就好了。
 * @Author: yuhua
 * @Date: 2018/11/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStart.class)
public class TestController {
    @Autowired
    private FileToByteArrayService fileToByteArrayService;
    @Autowired
    private UploadService uploadService;
    @Test
    public void testDemo() throws IOException {
        //原文件的位置（需根据自己情况修改）
        String fileSrc = "D:\\tempfile\\elasticsearch.zip";
        byte[] bytes = fileToByteArrayService.fileToBytes(fileSrc);
        /**
         * 演示过程中，下面这行代码是否注释掉说明：
         * 1.演示通过springboot注入方式去调用UploadService()中的方法需要注释掉。
         * 2.演示通过new实例方式进入到UploadService去调用方法出现空指针问题，则需要保留这行代码。
         * 3.演示通过new实例方式进入到UploadService去调用方法，通过在UploadService中set值解决问题，则这行代码不能注释掉。
         */
        UploadService uploadService = new UploadService();
        try {
            UploadBlockInputVo param = new UploadBlockInputVo();
            param.setFileName("elasticsearch-6.4.2");
            param.setOffset(0);
            param.setLength(1000000 * 25);
            param.setPartNumber(1);
            param.setSuffix(".zip");
            param.setBytes(bytes);
            uploadService.uploadBlock(param);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
