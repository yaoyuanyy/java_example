package com.yy.example.pattern_mode.action.visitor;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-03 at 10:44
 */
public class Engine implements Element {

    private String name;
    private String desc;
    private int usedYears;


    public int getUsedYears() {
        return usedYears;
    }

    public void setUsedYears(int usedYears) {
        this.usedYears = usedYears;
    }

    public Engine(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
