package com.yy.example.pattern_mode.action.responsibility_chain;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-02-26 at 11:00
 */
public class RequestObj {

    private String id;
    private String content;
    private String toAddr;
    private Integer type = 1;

    public RequestObj(){}

    public RequestObj(String id, String content, String toAddr, Integer type) {
        this.id = id;
        this.content = content;
        this.toAddr = toAddr;
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToAddr() {
        return toAddr;
    }

    public void setToAddr(String toAddr) {
        this.toAddr = toAddr;
    }
}
