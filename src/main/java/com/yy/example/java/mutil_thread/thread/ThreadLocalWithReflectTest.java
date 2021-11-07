package com.yy.example.java.mutil_thread.thread;

import java.lang.reflect.Field;

/**
 * <pre></pre>
 * NB.
 * Created by skyler on 2021/08/18 at 下午8:57
 */
public class ThreadLocalWithReflectTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> tl = new ThreadLocal();
        Thread thread = new Thread(() -> {
            try {
                int i = 1;
                testThreadLocalWithGC("aa" + i, i == 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.join();
    }

    private static void testThreadLocalWithGC(String value, boolean flag) throws NoSuchFieldException, IllegalAccessException {
         new ThreadLocal().set(value);

//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set(value);

        printEntryOfThreadLocalMapOfThread();

        if(flag) {
            System.gc();
            System.out.println("手动触发System.gc完成");
        }
        // threadLocal.remove();
        printEntryOfThreadLocalMapOfThread();
    }

    private static void printEntryOfThreadLocalMapOfThread() throws NoSuchFieldException, IllegalAccessException {
        Thread thread = Thread.currentThread();
        Class classOfThread = thread.getClass();
        Field fieldOfThread = classOfThread.getDeclaredField("threadLocals");
        fieldOfThread.setAccessible(true);
        Object threadLocalMap = fieldOfThread.get(thread);

        Class classOfThreadLocalMap = threadLocalMap.getClass();
        Field fieldOfThreadLocalMap = classOfThreadLocalMap.getDeclaredField("table");
        fieldOfThreadLocalMap.setAccessible(true);
        Object[] entriesOfThreadLocalMap = (Object[]) fieldOfThreadLocalMap.get(threadLocalMap);

        // System.out.println("entriesOfThreadLocalMap length:" + entriesOfThreadLocalMap.length);
        for (int i = 0; i < entriesOfThreadLocalMap.length; i++) {
            Object entry = entriesOfThreadLocalMap[i];
            if(null != entry) {
                Class classOfEntry = entry.getClass();
                Field fieldOfEntry = classOfEntry.getDeclaredField("value");
                fieldOfEntry.setAccessible(true);
                Object valueOfEntry = fieldOfEntry.get(entry);

                Field referentOfSuperEntry = classOfEntry.getSuperclass().getSuperclass().getDeclaredField("referent");
                referentOfSuperEntry.setAccessible(true);
                Object valueOfReferentOfSuperEntry = referentOfSuperEntry.get(entry);

                System.out.println("Entry key:" + valueOfReferentOfSuperEntry + " --> Entry value:" + valueOfEntry);
            }
//            else {
//                System.out.println("Entry is null index:" + i);
//            }
        }
    }

}
