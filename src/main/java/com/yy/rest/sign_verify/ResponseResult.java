package com.yy.rest.sign_verify;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ResponseBody返回的JSON对象->字符串类
 *
 * @date 2017-03-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseResult<T> implements Serializable {
    /**
     * 0表示成功，>0表示失败,<0系统保留
     */
    private int code = 0;

    /**
     * 提示信息
     */
    private String msg = "";

    /**
     * 详细提示信息
     */
    private String detailMsg = "";

    /**
     * 返回数据
     */
    private T data;

    /**
     * @return
     */
    public static ResponseResult success() {
        return success(new Object());
    }

    /**
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(final T data) {
        return build(0, "", "", data);
    }

    /**
     * @param code
     * @param msg
     * @return
     */
    public static ResponseResult failure(final int code, final String msg) {
        return failure(code, msg, "");
    }

    /**
     * @param errorCode
     * @return
     */
    public static ResponseResult failure(final ErrorCode errorCode) {
        return failure(errorCode, "");
    }

    /**
     * @param errorCode
     * @param detailMsg
     * @return
     */
    public static ResponseResult failure(final ErrorCode errorCode, final String detailMsg) {
        return failure(errorCode.getCode(), errorCode.getMessage(), detailMsg);
    }

    /**
     * @param errorCode
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult failure(final ErrorCode errorCode, final T data) {
        return build(errorCode.getCode(), errorCode.getMessage(), "", data);
    }

    /**
     * @param msg
     * @return
     */
    public static ResponseResult failure(final String msg) {
        return failure(-1, msg, "");
    }

    /**
     * @param msg
     * @param detailMsg
     * @return
     */
    public static ResponseResult failure(final String msg, final String detailMsg) {
        return failure(-1, msg, detailMsg);
    }

    /**
     * @param code
     * @param msg
     * @param detailMsg
     * @return
     */
    public static ResponseResult failure(final int code, final String msg, final String detailMsg) {
        return build(code, msg, detailMsg, new Object());
    }

    /**
     * @param code
     * @param msg
     * @param detailMsg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult build(final int code, final String msg, final String detailMsg, final T data) {
        return new ResponseResult<>(code, msg, detailMsg, data);
    }
}
