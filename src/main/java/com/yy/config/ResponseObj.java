package com.yy.config;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/29 at 下午4:47
 */
public class ResponseObj<T> {

    private int code;
    private String msg;
    private T data;

    public static final ResponseObj<Object> SUCCESS = new ResponseObj<Object>(AppCode.SUCCESS);
    public static final ResponseObj<Object> ERROR = new ResponseObj<Object>(AppCode.ERROR);

    public ResponseObj(AppCode appCode){
        this.code = appCode.getCode();
        this.msg = appCode.getDescription();
    }

    public ResponseObj(AppCode appCode, T data){
        this.code = appCode.getCode();
        this.msg = appCode.getDescription();
        this.data = data;
    }

    public ResponseObj(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseObj(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseObj success(Object data) {
        return new ResponseObj(AppCode.SUCCESS, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
