package com.yy.example.pattern_mode.structure.composite.security;

import com.yy.example.pattern_mode.structure.composite.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 目录 composite
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 11:03
 */
public class Catalog implements Item {

    private String name;
    private int level;

    private List<Item> items = new ArrayList<>();

    public Catalog(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public void print() {
        // 打印自己的信息
        System.out.println(PrintUtils.prefix(level)+name+"("+level+")");
        for (Item item : items) {
            // 打印item的信息
            item.print();
        }
    }

    public void add(Item item){
        items.add(item);
    }

    public void remove(Item item){
        items.remove(item);
    }



}
