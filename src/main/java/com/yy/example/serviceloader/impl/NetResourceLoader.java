package com.yy.example.serviceloader.impl;

import com.yy.example.serviceloader.CustomResourceLoader;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-22 at 18:07
 */
public class NetResourceLoader implements CustomResourceLoader {
    @Override
    public String getResource(String path) {
        return "net";
    }
}
