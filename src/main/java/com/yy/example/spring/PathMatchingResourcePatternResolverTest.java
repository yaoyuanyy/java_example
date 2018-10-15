package com.yy.example.spring;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/9/24 at 上午10:39
 */
public class PathMatchingResourcePatternResolverTest {

    public static void main(String[] args) throws IOException {

//        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        String url = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "com/yy/" + "test.properties";
//        Resource[] resources = resourcePatternResolver.getResources(url);
//        String path = "";
//        for (Resource resource : resources) {
//            path = resource.getURL().getPath();
//            System.out.println("path:" + path);
//        }
//        Resource resource = resourcePatternResolver.getResource("file:" + path);
//        System.out.println(IOUtils.toString(resource.getInputStream(),"utf-8"));


        // resources下建立一个com.yy包，包下建个文件：test.properties
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        String url = ResourcePatternResolver.CLASSPATH_URL_PREFIX + "com/yy/" + "test.properties";
        Resource resource = resourcePatternResolver.getResource(url);
        // String text = IOUtils.toString(resource.getInputStream(),"utf-8");

        Properties properties = new Properties();
        properties.load(resource.getInputStream());

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String)enumeration.nextElement();
            System.out.println("key:"+key +" value:"+properties.getProperty(key));
        }
    }
}
