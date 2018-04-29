package com.yy.rest.sign_verify;

/**
 * 业务层错误码
 */
public enum ErrorCodeEnum implements ErrorCode {

    ERROR(1),
    /**
     * 用户不存在
     */
    USER_NOT_EXISTED(2),
    /**
     * 需要登录
     */
    LOGIN_REQUIRED(3),
    /**
     * 图片不允许为空
     */
    IMG_REQUIRED(4);

    private final int code;

    ErrorCodeEnum(final int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return LocaleUtils.getMessage("error.code." + this.code);
    }

    @Override
    public String toString() {
        return "[" + this.getCode() + "]" + this.getMessage();
    }
}
