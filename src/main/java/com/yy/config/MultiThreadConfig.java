package com.yy.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 自定义线程池
 * <p></p>
 * <pre>
 *     使用实例:
 *     public class yourController{
 *         @Autowired
 *         private ThreadPoolExecutor threadExecutor;
 *     }
 * </pre>
 * NB.
 * Created by skyler on 2018/8/2 at 上午10:21
 */
@Configuration
public class MultiThreadConfig {

    /**
     * NB. 此线程池executorHandler策略为调用方执行(if main thread invoke, 调用方即main thread)
     * @return
     */
    @Bean("threadExecutor")
    public ThreadPoolExecutor executor(){
        int coreProcessorCount = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(coreProcessorCount, coreProcessorCount + 10, 10,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(20), new BasicThreadFactory.Builder().namingPattern("anjia-multi-thread-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());

    }
}
