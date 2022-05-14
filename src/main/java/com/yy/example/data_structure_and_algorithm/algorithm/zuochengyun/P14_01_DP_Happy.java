package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

import java.util.List;

/**
 * Description: 派对的最大快乐值
 * <pre>
 * 树形dp套路题
 * https://www.bilibili.com/video/BV13g41157hK?p=14  00:22:00
 *
 * code: https://www.notion.so/f0dcf21dc1f44761a11a7fda4873be58#371464b8d5f34ad4a856e6986b066bc6
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/6/22 at 11:22 PM
 */
public class P14_01_DP_Happy {

    public static class Employee {
        int happy;
        List<Employee> nexts;

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    public int maxHappy(Employee boss) {
        NodeInfo nodeInfo = process(boss);
        return Math.max(nodeInfo.laiMaxHappy, nodeInfo.buMaxHappy);
    }

    public static class NodeInfo {
        int laiMaxHappy;
        int buMaxHappy;

        public NodeInfo(int laiMaxHappy, int buMaxHappy) {
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }
    }

    public NodeInfo process(Employee x) {
        if(x.nexts == null) {
            return new NodeInfo(x.happy, 0);
        }
        int resLai = x.happy;
        int resBu = 0;
        for (Employee next : x.nexts) {
            NodeInfo subNodeInfo = process(next);
            resLai += subNodeInfo.buMaxHappy;
            resBu += Math.max(subNodeInfo.laiMaxHappy, subNodeInfo.buMaxHappy);
        }
        return new NodeInfo(resLai, resBu);
    }

    public static void main(String[] args) {
        // todo
    }
}
