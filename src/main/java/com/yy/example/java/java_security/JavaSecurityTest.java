package com.yy.example.java.java_security;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Permission;

/**
 * Description:
 * <pre>
 *     refer to
 *     http://sweepingmonkgo.iteye.com/blog/2115800
 *     https://www.cnblogs.com/yiwangzhibujian/p/6207212.html
 * </pre>
 * NB.
 * Created by skyler on 2018/3/16 at 上午10:16
 */
public class JavaSecurityTest {

    public static void main(String[] args) throws FileNotFoundException {
        String url = System.getProperty("user.dir");
        System.out.println(url);

        // 开启安全性验证
        System.setSecurityManager(new MySecurityManager());
        FileInputStream fileInputStream = new FileInputStream(new File(url + "/dd.txt"));
    }


    static class MySecurityManager extends SecurityManager {
        @Override
        public void checkRead(String file) {
            System.out.println("-- my checkRead String--");
            super.checkRead(file);
        }

        @Override
        public void checkRead(FileDescriptor fd) {
            System.out.println("-- my checkRead FileDescriptor--");
            super.checkRead(fd);
        }

        @Override
        public void checkPermission(Permission perm) {
            System.out.println("-- my checkPermission --");
            super.checkPermission(perm);
        }
    }
}
