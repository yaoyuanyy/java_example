package com.yy.example.data_structure_and_algorithm.algorithm.leetcode.ti_2_middle.c2_linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description:
 * <pre>
 *   两数相加：https://leetcode-cn.com/problems/two-sum/
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020-01-04 at 20:23
 */
public class LC1_PlusTwoNumber {

    public static void main(String[] args) {
        LC1_PlusTwoNumber c2PlusTwoNumber = new LC1_PlusTwoNumber();
        //test(plusTwoNumber);
        cal();
    }

    public static void cal(){
        LC1_PlusTwoNumber c2PlusTwoNumber = new LC1_PlusTwoNumber();
        c2PlusTwoNumber.add(new ListNode(2, null));
        c2PlusTwoNumber.add(new ListNode(4, null));
        c2PlusTwoNumber.add(new ListNode(5, null));

        LC1_PlusTwoNumber c2PlusTwoNumber2 = new LC1_PlusTwoNumber();
        c2PlusTwoNumber2.add(new ListNode(5, null));
        c2PlusTwoNumber2.add(new ListNode(6, null));
        c2PlusTwoNumber2.add(new ListNode(5, null));

        // 342+465=807
        cal1(c2PlusTwoNumber.header, c2PlusTwoNumber2.header);

    }
    public static void cal1(ListNode node1, ListNode node2){
        List<Integer> list = new ArrayList<>();
        int pre = 0;
        while (node1 != null || node2 != null) {
            int value = (node1 == null ? 0 : node1.value);
            int value2 = (node2 == null ? 0 : node2.value);
            int sum = value + value2 + pre;
            pre = sum / 10;
            int remaind = sum % 10;
            list.add(0, remaind);
            node1 = (node1 == null ? null : node1.next);
            node2 = (node2 == null ? null : node2.next);
        }

        if(pre > 0) {
            list.add(0, pre);
        }
        System.out.println(list);
    }

    public static void test(LC1_PlusTwoNumber c2PlusTwoNumber) {
        c2PlusTwoNumber.add(new ListNode(1, null));
        c2PlusTwoNumber.add(new ListNode(2, null));
        c2PlusTwoNumber.add(new ListNode(3, null));
        c2PlusTwoNumber.add(new ListNode(4, null));

        ListNode header = c2PlusTwoNumber.getHeader();
        c2PlusTwoNumber.output(header);
    }
    public void output(ListNode node){
        if(node == null){
            return;
        }
        System.out.println("node.value:" + node.value);
        output(node.next);
    }

    ListNode header;
    ListNode tail;

    public ListNode getHeader(){
        return header;
    }


    public void add(ListNode node) {
        if(Objects.isNull(header)) {
            header = node;
            tail = node;
        }else {
            ListNode tmp = tail;
            tail = node;
            tmp.next = node;
        }
    }
}
