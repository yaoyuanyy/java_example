package com.yy.example.callback;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 16:10
 */
public class ContextHolder {

    private static final ThreadLocal<Context> contextHolder = new ThreadLocal<Context>();

    public static ThreadLocal<Context> getContextHolder() {
        return contextHolder;
    }

    public static Context getContext(){
        return contextHolder.get();
    }

    public static void setContext(Context context){
        contextHolder.set(context);
    }

    public static void clearContext(){
        System.out.println("准备清除context holder " + "current Thread:" + Thread.currentThread().getName());
        contextHolder.remove();
    }
}
