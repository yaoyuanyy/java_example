package com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Description: 获取最大的 Top M
 * <pre>
 * 所以使用小顶堆
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 5/29/22 at 10:17 AM
 */
public class C2_04_01_TopM {

    /**
     * 读取一个每行都是数字的文件，找出最大的前10个数，数字范围 0 ~ Integer.Max
     * 进阶：以降序输出
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        BufferedReader reader = getFileReader();
        // 定义一个长度为 10 的小顶堆
        C2_04_01_MinPQ_Impl_Heap minPQ = new C2_04_01_MinPQ_Impl_Heap(10 + 1);
        String line;
        while ((line = reader.readLine()) != null) {
            Integer num = Integer.parseInt(line);
            minPQ.insert(num);
            if (minPQ.size() > 10) {
                minPQ.delMin();
            }
        }

        // 如果想降序输出，for 里面放入栈中，再 for 输出
        int size = minPQ.size();
        for (int i = 0; i < size; i++) {
            System.out.print(minPQ.delMin() + " ");
        }
    }

    public static BufferedReader getFileReader() throws Exception {
        // 读取一个文件：classpath下的文件
        String classPath = C2_04_01_TopM.class.getResource("/").getPath();
        String resource = "TopM-resource.txt";
        String path = classPath + resource;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader;
    }
}