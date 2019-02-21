package com.yy.example.spring;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Description: 读取classpath下或指定目录下的test.properties内容
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/24 at 上午10:39
 */
public class PathMatchingResourcePatternResolverTest {

    public static void main(String[] args) throws IOException {

       PathMatchingResourcePatternResolverTest test = new PathMatchingResourcePatternResolverTest();
       test.readFromMoreUrl();

    }

    public Map<String, Object> readFromMoreUrl() throws IOException {
        Map map = new HashMap();
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String url = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "com/yy/" + "test.properties";
        Resource[] resources = resourcePatternResolver.getResources(url);
        String path = "";
        for (Resource resource : resources) {
            System.out.println("path:" + resource.getURL().getPath());
            /**
             * 这里是直接从inputStream打印出来了，实际用的时候可以使用
             * Properties properties = new Properties();
             * Enumeration enumeration = properties.load(resource.getInputStream());
             * 进一步使用
             */
            System.out.println(IOUtils.toString(resource.getInputStream(), "utf-8"));
        }

        return map;

    }

    public Map<String, Object> readFromSingleUrl() throws IOException {

        Map map = new HashMap();
        // resources下建立一个com.yy包，包下建个文件：test.properties
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String url = ResourcePatternResolver.CLASSPATH_URL_PREFIX + "com/yy/" + "test.properties";
        Resource resource = resourcePatternResolver.getResource(url);

        // 可以直接打印InputStream的内容
        // String text = IOUtils.toString(resource.getInputStream(),"utf-8");

        Properties properties = new Properties();
        properties.load(resource.getInputStream());

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            map.put(key, properties.getProperty(key));
            System.out.println("key:" + key + " value:" + properties.getProperty(key));
        }

        return map;
    }
}
