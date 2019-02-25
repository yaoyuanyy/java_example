package com.yy.example.pattern_mode.composite.security;

import com.yy.example.pattern_mode.composite.PrintUtils;

/**
 * Description: 叶子目录 leaf
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-25 at 11:12
 */
public class Content implements Item{

    private String name;
    private int level;

    public Content(String name, int level) {
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

        System.out.println(PrintUtils.prefix(level)+name+"("+level+")");
    }
}
