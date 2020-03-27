package com.yy.example.pattern_mode.action.iterator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 11:12
 */
public class ConcreteAggregate extends Aggregate {

    Object[] objects = new Object[10];
    int positon = 0;

    @Override
    public void add(Object object){
        if(positon < objects.length) {
            objects[positon++] = object;
        }else {
            System.out.println("对象数据里数据已满");
        }
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(objects);
    }

}
