package com.yy.example.java.collections_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/18 at 上午10:01
 */
public class CollectionsTest {

    public static void main(final String[] args) {
        final List l1 = new ArrayList();
        Collections.addAll(l1, 1, 1, 2, 5);
        final List l2 = new ArrayList();
        Collections.addAll(l2, 2, 3, 6);


        /**
         * ------ 如果两个指定collection中没有相同的元素方法为true
         */
        System.out.println("disjoint:" + Collections.disjoint(l1, l2));

        /**
         * ------ 反转集合数据的顺序
         */
        Collections.sort(l1, Collections.reverseOrder());
        l1.forEach(System.out::println);


        /**
         * ------ 按照步长旋转集合
         * For example, suppose list is [t, a, n, k, s]. After invoking Collections.rotate(list, 1) (or Collections.rotate(list, -4)),
         * list will be [s, t, a, n, k].
         */
        l1.forEach(System.out::print);
        System.out.println();
        Collections.rotate(l1, 1);
        l1.forEach(System.out::print);


        /**
         * ------ 指定集合是否包含一个集合的所有元素，如集合l1: "1, 1, 2, 5"，tmp："1, 5"，调用l1.retainAll(tmp))，返回true
         */
        System.out.println();
        final List tmp = new ArrayList();
        Collections.addAll(tmp, 1, 5);
        System.out.println("Collections.retainAll:" + l1.retainAll(tmp));


        /**
         * ------ 返回指定元素在集合中出现的次数
         */
        System.out.println("Collections.frequency:" + Collections.frequency(l1, 1));

        /**
         * ------
         */
        final List<Integer> checkLists = Collections.checkedList(l1, Integer.class);
        checkLists.forEach(System.out::println);


        //Collections.asLifoQueue()

        /**
         * ------ 返回最后找到的指定子集合的位置
         */
        final List ll = new ArrayList();
        Collections.addAll(ll, 2, 3, 6, 5, 3, 6);
        final List subLl = new ArrayList();
        Collections.addAll(subLl, 3, 6);
        System.out.println("Collections.lastIndexOfSubList:" + Collections.lastIndexOfSubList(ll, subLl));

        /**
         * ------ 生成指定长度的集合，元素全部为指定的元素
         */
        final List<String> list = Collections.nCopies(3, "a");
        list.forEach(System.out::println);

        /**
         * ------ 集合元素全部被赋值为指定元素
         */
        final List fillTmp = new ArrayList();
        Collections.addAll(fillTmp, 2, 3, 6);
        Collections.fill(fillTmp, 3);
        fillTmp.forEach(System.out::print);
    }
}
