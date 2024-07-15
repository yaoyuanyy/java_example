package com.yy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yy.example.data_structure_and_algorithm.algorithm.book_algorithm_4.C2_04_01_TopM;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        String path = getFilePath();
//        getDataWithBufferedReader(path);

//        getDataWithJava8(path);

//        getDataWithScanner(path);

//        getAllDataWithJava8(path);

        getAllDataWithCommonsIO(path);

        String dataWithArray = getFilePath();
        //getAllDataWithCommonsIOAndToString(dataWithArray);

        getAllDataWithGuavaAndToString(dataWithArray);

    }
    public static String getFilePath() throws Exception {
        // 读取一个文件：classpath下的文件
        String classPath = ReadFile.class.getResource("/").getPath();
        String resource = "common/data.txt";
        String path = classPath + resource;
        return path;
    }

    public static String getFilePathWithArray() throws Exception {
        // 读取一个文件：classpath下的文件
        String classPath = ReadFile.class.getResource("/").getPath();
        String resource = "common/dataWithArray.txt";
        String path = classPath + resource;
        return path;
    }
    public static void getDataWithBufferedReader(String path) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 业务逻辑处理
                System.out.println(line);
            }
        }
    }

    public static void getDataWithJava8(String path) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            stream.forEach(System.out::println);
        }
    }

    public static void getDataWithScanner(String path) throws Exception {
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    public static void getAllDataWithJava8(String path) throws Exception {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }
        }catch (Exception exception){

        }
    }

    public static void getAllDataWithCommonsIO(String path) throws Exception {
        try {
            List<String> lines = FileUtils.readLines(new File(path));
            for (String line : lines) {
                System.out.println(line);
            }
        }catch (Exception exception){

        }
    }

    /**
     * 文件内容是大数组：[{},{}]
     * @param path
     * @throws Exception
     */
    public static void getAllDataWithCommonsIOAndToString(String path) throws Exception {
        try {
            String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
            List<JSONObject> jsonArray = JSON.parseArray(content, JSONObject.class);
            for (JSONObject jsonObject : jsonArray) {
                System.out.println(jsonObject.toJSONString());
            }
        }catch (Exception exception){

        }
    }

    /**
     * 文件内容是大数组：[{},{}]
     * @param path
     * @throws Exception
     */
    public static void getAllDataWithGuavaAndToString(String path) throws Exception {
        try {
            String content = com.google.common.io.Files.asCharSource(new File(path), StandardCharsets.UTF_8).read();
            List<JSONObject> jsonArray = JSON.parseArray(content, JSONObject.class);
            for (JSONObject jsonObject : jsonArray) {
                System.out.println(jsonObject.toJSONString());
            }
        }catch (Exception exception){

        }
    }
}
