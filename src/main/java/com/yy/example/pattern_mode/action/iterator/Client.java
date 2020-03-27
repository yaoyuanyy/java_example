package com.yy.example.pattern_mode.action.iterator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 12:29
 */
public class Client {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("a");
        aggregate.add("bb");
        aggregate.add("ccc");
        aggregate.add("dddd");
        aggregate.add("eeeee");

        Iterator iterator = aggregate.createIterator();
        while (iterator.isDone()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
