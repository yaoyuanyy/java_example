package com.yy.rest.sign_verify;

public interface ErrorCode {
    /**
     * 错误代号
     *
     * @return 错误代号
     */
    int getCode();

    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
