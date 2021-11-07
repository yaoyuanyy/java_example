package com.yy.example.spring.anno_schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.*;
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
public class CustomerScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {

        return Executors.newScheduledThreadPool(10, new ThreadFactory() {

            AtomicInteger count = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "skyler thread-->" + count.getAndIncrement());
            }
        });
    }

    public Executor executor() {

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors() * 2,
                new BasicThreadFactory.Builder()
                        .namingPattern("skyler-thread-pool-%d")
                        .daemon(true)
                        .build());

        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors() * 2,
                50, 10,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(50),
                new ThreadFactoryBuilder().setNameFormat("skyler-thread-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        return executor;
    }
}
