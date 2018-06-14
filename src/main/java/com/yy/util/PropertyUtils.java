package com.yy.util;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/14 at 下午5:46
 */
public class PropertyUtils {

    private PropertyUtils(){

    }

    public static Properties load(File file) throws IOException{

        InputStream in = null;
        try {
            in = new FileInputStream(file);
            Properties props = new Properties();
            props.load(in);

            return props;

        }finally{
            IOUtils.closeQuietly(in);
        }
    }

    public static Properties load(String path) throws IOException{

        InputStream in = null;
        try {
            in = PropertyUtils.class.getClassLoader().getResourceAsStream(path);
            Properties props = new Properties();
            props.load(in);

            return props;

        }finally{
            IOUtils.closeQuietly(in);
        }
    }
}

