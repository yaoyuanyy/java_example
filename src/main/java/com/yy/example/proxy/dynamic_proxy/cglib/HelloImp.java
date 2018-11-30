package com.yy.example.proxy.dynamic_proxy.cglib;

public class HelloImp{

    public String sayHello(String str) {

        System.out.println("sayHello");

        return "HelloImp: " + str;
    }
}