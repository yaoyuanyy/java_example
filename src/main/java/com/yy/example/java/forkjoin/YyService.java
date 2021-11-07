package com.yy.example.java.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by skyler on 2017/3/17.
 */
public class YyService {

    public static void main(String[] args) {
        YyService yyService = new YyService();
        yyService.cul(0, 10);

        System.out.println(4 >> 1);
    }

    public long cul(int first, int last) {
        YyTask yyTask = new YyTask(first,last);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(yyTask);
        //forkJoinPool.submit(yyTask);
        return 0;
    }

}

class YyTask extends RecursiveAction {

    private int first;
    private int last;

    public YyTask(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected void compute() {
        if(first >= last) return;

        if((last - first) <= 2) {
            handle(first, last);
        }else {
            int mid = (first + last) >> 1;
            YyTask left = new YyTask(first, mid);
            YyTask right = new YyTask(mid+1, last);
            //invokeAll(left, right);

            left.fork();
            right.fork();

            /*left.fork();
            right.compute();
            left.join();*/
        }
    }

    private void handle(int first, int last) {
        for(int i = first;i<=last;i++){
            System.out.println("current Thread:"+Thread.currentThread().getName()+" i:"+i+" last:"+last);
        }
    }
}
