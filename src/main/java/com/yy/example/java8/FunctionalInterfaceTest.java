package com.yy.example.java8;


@FunctionalInterface
interface Something{
    void sayHello(String hello);//这样的方法只能有一个
    static void sfsd(String hello) {
        System.out.println("static");
    }
    default String log(){
        return "second log, then print";
    }
}

public class FunctionalInterfaceTest{
	public static void main(String[] args) {
	    Something something = (s) ->System.err.println("ddd");
	    System.out.println(something.log());
	}

}
