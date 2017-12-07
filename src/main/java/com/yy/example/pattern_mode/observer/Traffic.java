package com.yy.example.pattern_mode.observer;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/7 at 上午11:38
 */
public class Traffic extends Data{

    private Integer carCount;
    private String street;
    private Boolean full;

    public Traffic(){}

    public Traffic(Integer carCount, String street, Boolean full) {
        this.carCount = carCount;
        this.street = street;
        this.full = full;
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "carCount=" + carCount +
                ", street='" + street + '\'' +
                ", full=" + full +
                '}';
    }

    public Integer getCarCount() {
        return carCount;
    }

    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Boolean getFull() {
        return full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }
}
