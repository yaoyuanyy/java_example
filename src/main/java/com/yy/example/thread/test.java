package com.yy.example.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yaoliang on 2017/2/17.
 */
public class test {
//    public static void main(String[] args) {
//        System.out.println(ResponseJson.getFailedResponse());
//
//        System.out.println(ResponseJson.getFailedResponse("s"));
//        System.out.println(ResponseJson.getFailedResponse());
//
//        Outer outer = new Outer.Inner().setIndex(1).builder();
//        System.out.println(outer.toString());
//    }

    private static void startModifyThread(final List<String> list) {
        Thread modifyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("item " + i);
                    list.add("item " + i);
                    try {
                        Thread.sleep((int) (Math.random() * 10));
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        modifyThread.start();
    }

    private static void startIteratorThread(final List<String> list) {
        Thread iteratorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (true) {
                    synchronized (list) {
                        while (true) {
                            for (String str : list) {
                                System.out.println("--- " + str);
                            }
                        }
                    }
                //}
            }
        });
        iteratorThread.start();
    }

    public static void main(String[] args) {
        final List<String> list = Collections
                .synchronizedList(new ArrayList<String>());
        startModifyThread(list);
        startIteratorThread(list);

    }

}

class Outer{
    private String name;
    private int index;

    public Outer(String name, int index) {
        this.name = name;
        this.index = index;
    }
    static class Inner{
        private String name;
        private int index;
        public Inner setName(String name) {
            this.name = name;
            return this;
        }
        public Inner setIndex(int index) {
            this.index = index;
            return this;
        }
        public Outer builder() {
            return new Outer(name, index);
        }
    }

    @Override
    public String toString() {
        return "Outer{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
class ResponseJson {
    private int code = 1;
    private String msg = "1";
    private Object data = new Object();

    private transient final static ResponseJson successResponse = new ResponseJson(0);
    private transient final static ResponseJson failResponse = new ResponseJson(1);


    public ResponseJson() {
    }

    public ResponseJson(int code) {
        super();
        this.code = code;
    }
    public ResponseJson(int code, boolean b) {
        super();
        this.code = code;
    }

    public ResponseJson(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public static ResponseJson getFailedResponse() {
        return ResponseJson.failResponse;
    }

    public static ResponseJson getFailedResponse(String msg) {
        ResponseJson response = ResponseJson.failResponse;
        response.setMsg(msg);
        return response;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseJson [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
