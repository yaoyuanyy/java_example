package com.yy.rest.sign_verify;

public class SkylerException extends RuntimeException {
    /**
     * 构造函数
     */
    public SkylerException() {
        super();
    }

    /**
     * 信息
     *
     * @param msg
     */
    public SkylerException(final String msg) {
        super(msg);
    }

    /**
     * @param msg   信息
     * @param cause 原因
     */
    public SkylerException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
