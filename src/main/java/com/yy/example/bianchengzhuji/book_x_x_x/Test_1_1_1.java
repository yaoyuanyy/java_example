package com.yy.example.bianchengzhuji.book_x_x_x;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Description:
 * <pre>
 * 问题：如何给一个磁盘文件排序
 * 具体问题：一个最多包含n个正整数的文件，每个数都小于n，n=10⁷，每个数都不重复，将这个文件的正整数升序排列输出
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2021-03-18 at 09:56
 */
public class Test_1_1_1 {

    public static void main(String[] args) {
        // method_1();
        //method_2_1();
        method_2_2();
    }

    /**
     * 约束：内存无限制
     * 采用位图法，定义一个10⁷长度的位图，
     *
     * 思路：由于每个7位十进制整数表示一个小于1000万的整数。我们可以使用一个具有1000万个位的字符串来表示这个文件，其中，当且仅当整数i在文件中存在时，第i位为1
     * 第一步，将所有的位都置为0，从而将集合初始化为空。
     * 第二步，通过读入文件中的每个整数来建立集合，将每个对应的位都置为1。
     * 第三步，检验每一位，如果该位为1，就输出对应的整数。
     *
     * NOTE: 位图的的方法有必要强调一下，就是位图的适用范围为针对不重复的数据进行排序，若数据有重复，位图方案就不适用了
     */
    public static void method_1() {
        // 1. 初始化
        BitSet bitSet = new BitSet(10000000);

        // 2. 逻辑赋值
        readFile(bitSet);

        // 3. 升序输出
        out(bitSet);
    }


    private static void out(Object bitSet) {
        System.out.println(bitSet);
    }

    public static void readFile(BitSet bitSet) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String path = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/" ) + "/Test_1_1_1_testData.log";
        File file = new File(path);
        if(!file.exists()) {
            System.err.println("文件路径不存在" + path);
            return;
        }

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
                bufferedReader.lines().mapToInt(o -> Integer.parseInt(o)).forEach(num -> {
                    bitSet.set(num);
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /// 能否用800万个可用位来表示最多1000万个整数呢 如何用1M=800万个bit存放1000万个数据呢

    /**
     * 约束：内存1M，足够的磁盘空间
     * 分两次获取，一次获取500万个，因为500万个bit/8=0.625M < 1M，满足约束条件
     * 第一次，只处理1—4999999之间的数据，这些数都是小于5000000的，对这些数进行位图排序，只需要约5000000/8=625000Byte，也就是0.625M，排序后输出。
     * 第二次，扫描输入文件时，只处理4999999-10000000的数据项，也只需要0.625M（可以使用第一次处理申请的内存）。
     * 因此，总共也只需要0.625M
     * 参考：https://www.pdai.tech/md/algorithm/alg-domain-bigdata-outsort.html
     *
     */
    public static void method_2_1() {
        IntStream.range(0,2).forEach(o -> {
            // 1. 初始化
            BitSet bitSet = new BitSet(5000000);
            // 2. 逻辑赋值
            readFileForMethod2(bitSet, o);
            System.out.println("第" + o + "次完成");
            // 3. 升序输出
            out(bitSet);
        });
    }

    public static void readFileForMethod2(BitSet bitSet, int index) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String path = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/" ) + "/Test_1_1_1_testData.log";
        File file = new File(path);
        if(!file.exists()) {
            System.err.println("文件路径不存在" + path);
            return;
        }

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
                bufferedReader.lines().mapToInt(o -> Integer.parseInt(o)).forEach(num -> {
                    if(index < 1) {
                        if(num < 5000000) {
                            bitSet.set(num);
                        }
                    }else {
                        if(num >= 5000000) {
                            bitSet.set(num);
                        }
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 约束：内存1M，足够的磁盘空间
     * 如果每个正整数用32位整型来表示的话，在1M存储空间里可以存储25万个正整数，因此，可以使用遍历输入文件40躺的程序来完成排序
     *
     */
    public static void method_2_2() {
        IntStream.range(0,40).forEach(o -> {
            // 1. 初始化
            List<Integer> list = new ArrayList<>(250000);
            // 2. 逻辑赋值
            readFileForMethod2_2(list, o);
            System.out.println("第" + o + "次完成");
            list.sort(Integer::compareTo);
            // 3. 升序输出
            out(list);
        });
    }

    public static void readFileForMethod2_2(List<Integer> array, int index) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        String path = userDir + "/src/main/java/com.yy.example.bianchengzhuji.book_x_x_x".replaceAll("\\.", "/" ) + "/Test_1_1_1_testData.log";
        File file = new File(path);
        if(!file.exists()) {
            System.err.println("文件路径不存在" + path);
            return;
        }

        int step = 250000;
        int minIndex = index * step;
        int maxIndex = (index + 1) * step;
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
                bufferedReader.lines().mapToInt(o -> Integer.parseInt(o)).forEach(num -> {
                    if (minIndex <= num && num < maxIndex) {
                        array.add(num);
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 约束：运行时间最多几分钟，10秒钟是最好的了
     *
     *
     * @param target
     * @param location
     */
    public static void method_3(char[] target, int location) {

    }
}
