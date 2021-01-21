package com.yy.example.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-05-22 at 16:25
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("VM.current().details():" + VM.current().details());
        System.out.println("----------------");
        System.out.println(ClassLayout.parseClass(Consumer.class).toPrintable());
        System.out.println("===============");
        System.out.println(ClassLayout.parseInstance(new Consumer()).toPrintable());

    }
}
