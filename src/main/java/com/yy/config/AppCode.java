package com.yy.config;

public enum  AppCode {
    SUCCESS(200, "success"),
    ERROR(500, "system error");

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    AppCode() {}

    AppCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
}