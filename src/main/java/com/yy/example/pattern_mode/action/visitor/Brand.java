package com.yy.example.pattern_mode.action.visitor;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:46
 */
public class Brand implements Element {

    private String name;
    private int code;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Brand(String name, int code, int level) {
        this.name = name;
        this.code = code;
        this.level = level;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
