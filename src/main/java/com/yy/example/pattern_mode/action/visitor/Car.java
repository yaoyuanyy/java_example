package com.yy.example.pattern_mode.action.visitor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Description: object-structure
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:37
 */
public class Car {

    List<Element> elements = new CopyOnWriteArrayList();

    public void add(Element e){
        elements.add(e);
    }

    public String info(Visitor visitor){
        elements.forEach(element -> {
            element.accept(visitor);
        });

        return "";
    }
}
