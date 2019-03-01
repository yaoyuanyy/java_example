package com.yy.example.callback;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-01 at 16:13
 */
public class Context {

    private String name;
    private String id;

    public Context(){}

    public Context(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
