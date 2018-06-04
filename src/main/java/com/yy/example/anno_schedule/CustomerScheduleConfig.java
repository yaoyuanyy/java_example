package com.yy.example.anno_schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/6/4 at 下午6:22
 */
@Configuration
@EnableScheduling
public class CustomerScheduleConfig implements SchedulingConfigurer{

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {

        return Executors.newScheduledThreadPool(10, new ThreadFactory(){

            AtomicInteger count = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "skyler thread-->"+count.getAndIncrement());
            }
        });
    }
}
