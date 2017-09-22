package com.yy.example.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>模拟生产者消费者模式，通过使用{@link ReentrantLock} {@link Condition await()}
 * {@link Condition singal()} 完成这个模拟工作
 * </p>
 * Created by skyler on 2017/9/15 at 上午11:52
 */
public class ConProWithLock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConProDemo conProDemo = new ConProDemo();
        //ExecutorService service = Executors.newWorkStealingPool(3);
        ExecutorService service = Executors.newFixedThreadPool(20);

        //生产者线程
        IntStream.range(1, 10).forEach(i ->
            service.submit(() ->{
                conProDemo.set();
            })
        );

        //消费者线程
        IntStream.range(1, 10).forEach(i ->
            service.submit(() ->{
                conProDemo.get();
            })
        );

    }
}

/**
 * 资源类
 */
class ConProDemo{

    List<String> list = new ArrayList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition get_con = lock.newCondition();
    Condition set_con = lock.newCondition();

    public String get() {
        String result = "";
        try{
            //Thread.sleep(100);
            lock.lock();
            while (list.size() > 0) {
                System.out.println("get data---" + Thread.currentThread().getName());
                result = list.remove(0);
                get_con.await();
            }
            set_con.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }

        return result;

    }


    public void set(){
        try{
            lock.lock();
            //System.out.println("wo come set data");
            while (list.size() == 0) {
                System.out.println("set data---" + Thread.currentThread().getName());
                list.add("t");
                set_con.await();
                System.out.println("set 线程唤醒了");
            }
            get_con.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
