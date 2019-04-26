package com.bd.springphoenixhbase.pic.model.svd_pic;

import java.io.Serializable;

public class Pic implements Serializable {
    private String id;

    private byte[] file;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}