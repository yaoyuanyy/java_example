package com.yy.example.pattern_mode.proxy.dynamic_proxy.java.simple1;

public class HelloImp implements Hello{

    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }
}