package com.bd.springphoenixhbase.pic.model;

import com.bd.springphoenixhbase.config.annotation.HBaseModel;
import com.bd.springphoenixhbase.config.annotation.HBaseModelProperty;

import java.util.Arrays;

/**
 * @author 张博【zhangb@lianliantech.cn】
 */
@HBaseModel(tableName = "svd_pic")
public class SVDPic {

    @HBaseModelProperty(family = "rowKey", qualifier = "rowKey")
    private String rowKey;
    @HBaseModelProperty(family = "pic", qualifier = "file")
    private byte[] file;

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public byte[] getFile() {
        return Arrays.copyOf(file, file.length);
    }

    public void setFile(byte[] file) {
        this.file = Arrays.copyOf(file, file.length);
    }
}
