package com.yy.example.proxy.dynamic_proxy.java.simple;

public class HelloImp implements Hello{

    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }
}