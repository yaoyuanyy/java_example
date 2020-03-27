package com.yy.example.pattern_mode.action.iterator;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-27 at 11:07
 */
public class ConcreteIterator implements Iterator {

    private Object[] objects = new Object[10];
    private int index = 0;
    private int size;

    public ConcreteIterator(Object[] objects) {
        this.objects = objects;
        this.size = objects.length;
    }

    @Override
    public boolean isDone() {
        return index < size;
    }

    @Override
    public Object currentItem() {
        return objects[index];
    }

    @Override
    public void next() {
        index ++;
    }
}
