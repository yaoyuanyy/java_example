package com.yy.example.data_structure_and_algorithm.algorithm.book_biancheng_zhuji;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <pre>
 *  给定一个最多包含40亿个随机排列的32位整数的文件，找出一个不在文件中的32位整数。（在文件中至少确实一个这样的数-为什么？）。
 *  在具有足够内存的情况下，如何解决该问题？
 *  如果有几个外部的“临时”文件可用，但是仅有几百字节的内存，又该如何解决该问题？
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-03-19 at 07:45
 */
public class Test_2_1_1 {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/" ) + "/Test_2_1_1_testData.log";
        int step = 0;
        do {
            System.out.println("path:" + path);
            path = method_2(step, path);
            step++;

        }while (step < 32 && StringUtils.isNotBlank(path));

        System.out.println("map:" + resultMap +" list:" + result);

//        String userDir = System.getProperty("user.dir");
//        String path_0 = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/") + "/Test_2_1_1_testData_0" + 1 + ".log";
//        FileWriter fileWriter0 = new FileWriter(path_0);
//        write(fileWriter0, path_0, "22");
//        write(fileWriter0, path_0, "33");
//        fileWriter0.close();
    }

    /**
     * 具有足够内存的情况下: 位图法
     * 2³²=4 294 967 296=536 870 912 * 8=500M+
     *
     * 尝试使用位图法解决该问题，使用536 870 912个字节，约512M内存存储这40亿整数，存在该整数的位置1，最后遍历比特位，输出第一个比特位为0的位置即可
     *
     * 此处为简化实现这个逻辑，我缩小了范围：给定一个最多包含10个随机排列的4位整数(2⁴)的文件，找出一个不在文件中的32位整数，见：Test_2_1_1_testData.log
     */
    public static void method_1() {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(10);
        //bitSet.

    }

    private static List<Character> result = new ArrayList<>();

    private static Map<Integer, Integer> resultMap = new HashMap<>();


    /**
     * 能否使用二分搜索?
     * 这40亿个整数是随机排列的，因此普通的二分搜索不能找到那个不存在的数。但是我们可以基于二分搜索的思想。
     *
     * 一个整数有32位，我们按照每个比特位是0还是1，将要查找的数据范围一分为二。从最高比特位开始：
     *
     * 将最高比特位为0的放在一堆，为1的放在另外一堆
     * 如果一样多，则随意选择一堆，例如选0，则该位为0
     * 如果不一样多，选择少的一堆继续，如1更少，则该位为1
     *
     * 这里需要做一些解释：
     * 由于2^32个整数中，每一个比特位是1还是0的个数是相同的。如果在这40亿个整数中，某比特位为1和0的个数是相同的，则说明两边都有不存在的数。因此选择任意一堆即可。
     * 如果比特位1的整数比0的整数多，则说明，比特位为0的一堆数中，肯定缺少了一些数。而比特位为1的一堆数中，可能缺少一些数。因此，我们选择少的，也就是比特位为0的那一堆数。
     * 每一次选择，都记录选择的是0还是1，最多32次选择后，便可以至少找到一个整数，不存在这40亿数中。
     *
     */
    public static String method_2(int step, String path) throws IOException {
        String userDir = System.getProperty("user.dir");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        AtomicInteger length_0 = new AtomicInteger(0);
        AtomicInteger length_1 = new AtomicInteger(0);

        String path_0 = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/") + "/Test_2_1_1_testData_0_" + step + ".log";
        String path_1 = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/") + "/Test_2_1_1_testData_1_" + step + ".log";
        FileWriter fileWriter0 = new FileWriter(path_0);
        FileWriter fileWriter1 = new FileWriter(path_1);

        bufferedReader.lines().forEach(o -> {
            String s = BinaryFullUtils.outFullWithZero(o);
            if(StringUtils.isNotBlank(s)) {
                char c = s.charAt(step);
                System.out.println("s:" + s + " c:" + c);
                if(c == '0') {
                    length_0.getAndIncrement();
                    write(fileWriter0, path_0, o);
                }else if(c == '1'){
                    length_1.getAndIncrement();
                    write(fileWriter1, path_1, o);
                }else {
                    System.out.println("no target");
                }
            }
        });

        if(length_0.get() == 0) {
            resultMap.put(step, 0);
            return "";
        }

        if(length_1.get() == 0) {
            resultMap.put(step, 1);
            return "";
        }

        if(length_0.get() > length_1.get()) {
            result.add('1');
            System.out.println("step:" + step + " path1:" + path_1 + " length_0:" + length_0.get() + " length_1:" + length_1.get() + " result:" + result);
            return path_1;
        }

        result.add('0');
        System.out.println("step:" + step + " path0:" + path_0 + " length_0:" + length_0.get() + " length_1:" + length_1.get() + " result:" + result);
        return path_0;
    }

    private static void write(FileWriter fileWriter, String path, String s) {
        try {
            fileWriter.write(s);
            fileWriter.write(System.getProperty( "line.separator" ));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
