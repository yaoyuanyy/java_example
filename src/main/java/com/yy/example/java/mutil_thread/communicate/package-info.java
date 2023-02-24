/**
 * Description:
 * <pre>
 *     生产者-消费者模型实现方式汇总
 *     参考：https://tobebetterjavaer.com/thread/shengchanzhe-xiaofeizhe.html#%E9%92%88%E5%AF%B9notify%E6%96%B9%E6%B3%95
 *
 *     生产者消费者代码框架：
 *     public void run() {
 *         while (true) {
 *             synchronized (obj) {
 *                 while (condition) {
 *                     obj.wait();
 *                 }
 *                 // 业务逻辑
 *                 obj.notifyAll();
 *             }
 *         }
 *     }
 * </pre>
 * Created by yaoyihao1@gmail.com or skyler_11@163.com on 2023/2/17 at 09:31
 */
package com.yy.example.java.mutil_thread.communicate;