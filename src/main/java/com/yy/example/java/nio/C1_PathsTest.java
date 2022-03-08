package com.yy.example.java.nio;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Description:
 * <pre>
 *  https://www.happycoders.eu/java/how-to-construct-file-and-directory-names-with-file-path-paths/
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-11 at 16:05
 */
public class C1_PathsTest {

    public static void main(String[] args) {
        Path path = Paths.get("lujing", "zi-lujing");
        System.out.println("toAbsolutePath:" + path.toAbsolutePath());
        System.out.println(path.getName(0));
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.getNameCount());
        System.out.println(path.getFileSystem());
        System.out.println();

        Path subPath = path.resolve("sub-sub-lujing");
        System.out.println(path.getName(0));
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.getNameCount());
        System.out.println(path.getFileSystem());
        System.out.println();

        System.out.println("subPath toAbsolutePath:" + subPath.toAbsolutePath());
        System.out.println(subPath.getName(0));
        System.out.println(subPath.getParent());
        System.out.println(subPath.getRoot());
        System.out.println(subPath.getNameCount());
        System.out.println(subPath.getFileSystem());
        System.out.println();

        Path newPath = Paths.get("new-lu-jing", "new").resolve(path);
        System.out.println("newPath toAbsolutePath:" + newPath.toAbsolutePath());
        System.out.println(newPath.getName(0));
        System.out.println(newPath.getParent());
        System.out.println(newPath.getRoot());
        System.out.println(newPath.getNameCount());
        System.out.println(newPath.getFileSystem());
        System.out.println();

        System.out.println("subPath toAbsolutePath:" + subPath.toAbsolutePath());
        System.out.println(subPath.getName(0));
        System.out.println(subPath.getParent());
        System.out.println(subPath.getRoot());
        System.out.println(subPath.getNameCount());
        System.out.println(subPath.getFileSystem());
    }
}
