package com.yy.test;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * refer to: https://segmentfault.com/a/1190000014479792
 * Created by yaoliang on 2016/12/2.
 */
public class CompletableFutureTest {
    ExecutorService pool = Executors.newFixedThreadPool(10);

    @Test
    public void runAsync() {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("runAsyn");
            System.out.println("hello");
            int i = 10/0;
        }).exceptionally(throwable -> {
            System.out.println("exception:"+throwable.getMessage());
            return null;
        });
    }

    @Test
    public void supplyAsync() {
        CompletableFuture<User> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("runAsyn");
            System.out.println("hello");
            System.out.println("当前线程：" + Thread.currentThread());
            int i = 10/0;
            return new User("y", "yy");
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            System.out.println(throwable);
            return null;
        });
    }

    /**
     * Get和Join对报错信息的比较
     *
     * 结果：
     * future.get(); // 报62行出错
     * future.join(); // 报58行出错，即join()报错更准，直接定位到具体的报错代码
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void CompareGetAndJoin() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            //int i = 10 / 0;
            return 10;
        });

        //future.get();
        //future.join();
        System.out.println(future.complete(10));
    }

    @Test
    public void tt() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future:"+System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        System.out.println(System.currentTimeMillis());
        future.completeExceptionally(new Exception());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenApplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<User> future = CompletableFuture.supplyAsync(() -> {
            // 长时间的计算任务
            try {
                //return imGroup.editGroup(session.getUserInfo().getImUserId(), vo);
                System.out.println("当前线程：" + Thread.currentThread());
                return new User("y", "yy");
            } catch (Exception e) {
                e.printStackTrace();
                //log.error("Unrecoverable error{}", "");
                return null;
            }
        }, pool).thenApplyAsync(user -> {
            // 重新组装
            user.setName("dd");
            System.out.println("当前线程：" + Thread.currentThread());
            return new User("y2", "yy2");
        }, pool);

        User user = future.get();
        System.out.println(user + "----------------------------------");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("当前线程3：" + Thread.currentThread().getName());
                return new User("y", "u2");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }, pool).thenApplyAsync((u2) -> {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            return u2.getName();
        }, pool);

        String name = future1.get();
        System.out.println(name + "----------------------------------");
    }

    @Test
    public void thenAcceptAsync() throws ExecutionException, InterruptedException {
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            // 长时间的计算任务
            try {
                //return imGroup.editGroup(session.getUserInfo().getImUserId(), vo);
                System.out.println("当前线程：" + Thread.currentThread());
                return new User("y", "yy2");
            } catch (Exception e) {
                e.printStackTrace();
                //log.error("Unrecoverable error{}", "");
                return null;
            }
        }, pool).thenApplyAsync(u -> {
            // 重新组装
            u.setPwd("dd");
            System.out.println("当前线程：" + Thread.currentThread());
            return new User("y2", "yy2");
        }, pool).thenAcceptAsync(u -> {
            u.setName("thenAcceptAsync");
            System.out.println(u.getName());
        }, pool);

        User user2 = (User) future2.get();
        System.out.println(user2);
    }

    @Test
    public void thenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> new User())
                .thenCompose(u3 -> {

                    System.out.println("new CompletableFuture");
                    return CompletableFuture.supplyAsync(() -> "object convert String");
                });

        System.out.println("f3:" + f3.get());
    }

    @Test
    public void thenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> new User())
                //u和s关联进行相应操作后，把操作后的结果返回给CompletableFuture，此时用thenCombine方法
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    return "object convert String";
                }), (a, b) -> {
                    //此时a为User;b为String
                    System.out.println(a.getName());
                    System.out.println(b.length());
                    return "";
                });
        System.out.println("f4:" + f4.get());
    }

    @Test
    public void thenAcceptBothAsync() throws ExecutionException, InterruptedException {
        Source source = new Source();
        CompletableFuture f5 = CompletableFuture.supplyAsync(() -> new User("y5", "y55"))
                //方法作用：u和s关联进行相应操作后，通知某个subject这件事做完了，此时用thenAcceptBothAsync方法
                .thenAcceptBothAsync(CompletableFuture.supplyAsync(() -> {
                    System.out.println("");
                    Student stu = new Student("yy",3);
                    return stu;
                }), (u, s) -> {
                    //u和s操作后，把u.name赋值给source.s_name
                    u.setPwd("yy55");
                    int i = 1/0;
                    s.setLevel(2);
                    source.setS_name(u.getName());
                }, pool).whenComplete((q, b) -> {System.out.println(b.getMessage());});
        // System.out.println("f5:" + f5.complete(1));
        System.out.println("f5:" + f5.completeExceptionally(new Exception("exception")));
        System.out.println("f5:" + f5.get());

    }

    @Test
    public void applyToEither() throws ExecutionException, InterruptedException {
        Source source = new Source();
        CompletableFuture<Student> f6 = new CompletableFuture();
        CompletableFuture<String> f66 = f6.applyToEither(CompletableFuture.supplyAsync(() -> {
            Student stu = new Student("yy", 6);
            return stu;
        }),(s) -> s.getName());
        System.out.println("f66:" + f66.get());
    }
}

class User {
    private String name;
    private String pwd;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}

class Student{
    private String name;
    private int level;

    public Student(){}

    public Student(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

class Source{
    private String s_name;
    private int goal;

    public Source(){}

    public Source(String s_name, int goal) {
        this.s_name = s_name;
        this.goal = goal;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
