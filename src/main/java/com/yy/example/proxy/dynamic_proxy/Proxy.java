package com.yy.example.proxy.dynamic_proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by skyler on 2017/3/17.
 */
public class Proxy {

    public static Object newInstaceProxy(Class interfa, InvocationHandler handler) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        /*String str = "package com.yy.proxy.dynamic_proxy;\n" +
                "public class TankTimeProxy implements "+interfa.getName()+" {\n" +
                "\n" +
                "            Movable movable;\n" +
                "\n" +
                "            public TankTimeProxy(Movable movable) {\n" +
                "                this.movable = movable;\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void move() {\n" +
                "                long start = System.currentTimeMillis();\n" +
                "                movable.move();\n" +
                "                long end = System.currentTimeMillis();\n" +
                "                System.out.println(\"take time:\" + (end - start));\n" +
                "            }\n" +
                "        }";*/

        String methodStr = "";

        Method[] methods = interfa.getMethods();
       /* for (Method method :methods) {
            methodStr += "@Override \n " +
                    "public void "+method.getName()+"() {\n"+
                    "     long start = System.currentTimeMillis();\n" +
                    "     movable."+method.getName()+"();\n" +
                    "     long end = System.currentTimeMillis();\n" +
                    "     System.out.println(\"take time:\" + (end - start));\n" +
                    "}";

        }*/
        System.out.println("methods.length:"+methods.length);
        for (Method method : methods) {
            methodStr += "@Override \n " +
                    "public void "+method.getName()+"(){\n"+
                    "    try{\n"+
                    "        Method md = "+interfa.getName()+".class.getMethod(\""+method.getName()+"\");\n"+
                    "        h.invoke(this, md);\n"+
                    "    }catch(Exception e){} \n"+
                    "}";

        }

        String str = "package com.yy.proxy.dynamic_proxy;\n" +
                "import java.lang.*; \n"+
                "import java.lang.reflect.*; \n"+
                "public class TankTimeProxy implements "+interfa.getName()+" {\n" +
                "            InvocationHandler  h;\n"+
                "            public TankTimeProxy(InvocationHandler h) {\n" +
                "                this.h = h;\n" +
                "            }\n" +
                "\n" + methodStr +
                "\n}";

        //字符串写到.java文件中
        //String fileName = System.getProperty("user.dir")+File.separator+"maintest\\src\\main\\java\\com\\yy\\proxy\\dynamic_proxy\\TankTimeProxy.java";
        String fileName = "E:\\tomcat_test\\tmp\\src\\main\\java\\com\\yy\\proxy\\dynamic_proxy\\TankTimeProxy.java";

        //System.out.println(path);
        File f = new File(fileName);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(str.getBytes());
        fos.close();

        //编译.java文件并生成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null,fileManager,null,null,null,units);
        task.call();
        fileManager.close();

        // load .class files into memory and create an instance
        URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file:E:/tomcat_test/tmp/src/main/java/")});
        Class clazz = loader.loadClass("com.yy.proxy.dynamic_proxy.TankTimeProxy");
        System.out.println(clazz);
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        Object object = constructor.newInstance(handler);

        return object;
    }
}
