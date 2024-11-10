package com.yy.mysql;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

public class PidAndPort {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        System.out.println(runtimeMXBean.getVmName());
        System.out.println(runtimeMXBean.getVmVendor());
        String pid = runtimeMXBean.getName().split("@")[0];
        System.out.println("Pid is:" + pid);

        getPort(pid);

        System.out.println("finish get port");

        try {
            int i = System.in.read();
            System.out.println("read result:" + i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * java    71181 skyler  133u  IPv6 0xc87b473339f4834b      0t0  TCP localhost:63859->localhost:63858 (ESTABLISHED)
     * pid: 71181 port:63859
     * @param pid
     */
    public static void getPort(String pid) {
        try {
            // 执行命令（根据操作系统的不同调整命令）
            String command = "lsof -p " + pid;  // 或者 "netstat -tuln"（Linux）
            Process process = Runtime.getRuntime().exec(command);

            System.out.println("cmd:" + command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ESTABLISHED")) {  // 过滤出监听的端口
                    System.out.println("line: " + line);
                    int startIndex = line.indexOf(":");
                    int endIndex = line.indexOf("->");
                    String port = line.substring(startIndex+1, endIndex);
                    System.out.println("port: " + port);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getPort2(String pid) {
        String filePath = "/proc/" + pid + "/net/tcp";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("line:" + line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public void outSystemProperties(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Map<String, String> map = runtimeMXBean.getSystemProperties();
        map.forEach((k,v) -> System.out.println("system properties:" + k + " => " + v));
    }
}
