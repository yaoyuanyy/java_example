package com.yy.mysql_manual;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.*;

public class Test {

    /**
     * 到test.class所在本地目录下
     * cd ~/test/mysql
     * $ time java -cp .:./mysql-connector-java-5.1.45.jar Test "jdbc:mysql://127.0.0.1:3306/test123?useSSL=false&useServerPrepstmts=true&cachePrepstmts=true&connectTimeout=500&socketTimeout=170000" username password "select sleep (2.6), id from sbtest1 where id=?" 1
     *
     * 使用docker
     * $ time java -cp .:./mysql-connector-java-5.1.45.jar Test "jdbc:mysql://127.0.0.1:33002/test123?useSSL=false&useServerPrepstmts=true&cachePrepstmts=true&connectTimeout=500&socketTimeout=170000" root 123456"select sleep (2.6), id from sbtest1 where id=?" 1
     * @param args
     * @throws NumberFormatException
     * @throws InterruptedException
     * @throws ClassNotFoundException
     */
    public static void main(String args[]) throws NumberFormatException, InterruptedException, ClassNotFoundException {
        try {
            outPutPid();

            System.out.println("开始执行---");
            int i = System.in.read();
            System.out.println("read input result:" + i);
        }catch (Exception exception){
            System.err.println("执行异常---");
        }

        Class.forName("com.mysql.jdbc.Driver");

        String url = args[0];
        String user = args[1];
        String pass = args[2];
        String sql = args [3];
        // sql 参数
        String interval = args [4];

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            while (true) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setFetchSize(Integer.MIN_VALUE);
                stmt.setString(1, interval);
                ResultSet rs = stmt.executeQuery();
                rs.close();
                stmt.close();


                PreparedStatement stmt2 = conn.prepareStatement(sql);
                stmt2.setString(1, interval);
                rs = stmt2.executeQuery();

                while (rs. next()) {
                    System.out. println("fine");
                }
                rs.close();
                stmt2.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void outPutPid() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        System.out.println(runtimeMXBean.getVmName());
        System.out.println(runtimeMXBean.getVmVendor());
        String pid = runtimeMXBean.getName().split("@")[0];
        System.out.println("Pid is:" + pid);
    }
}
