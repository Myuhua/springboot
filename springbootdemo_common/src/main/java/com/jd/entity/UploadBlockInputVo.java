package com.jd.entity;

import java.io.Serializable;
import java.util.Arrays;

public class UploadBlockInputVo implements Serializable {

    private String uploadId;             //上传ID（在Start时候返回的）
    private String fileName;             //文件名称
    private byte[] bytes;                //文件内容
    private int offset;                  //起读位置（备用）
    private int length;                  //文件块长度
    private int partNumber;              //文件块编号，从1开始
    private String suffix;               //文件后缀名
    private String md5;                  //文件分片内容md5值

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "UploadBlockInputVo{" +
                "uploadId='" + uploadId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                ", offset=" + offset +
                ", length=" + length +
                ", partNumber=" + partNumber +
                ", suffix='" + suffix + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
