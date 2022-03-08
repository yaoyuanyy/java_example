/**
 * Description:
 * <pre>
 * 技术点：SPI
 * Service Provider Interface翻译成中文就是服务提供接口，简称SPI，它是JDK内置的一种机制，用途就是本地服务发现和提供。
 * 在Java中通过基于接口的编程+策略模式+配置文件来实现SPI这一套机制。
 *
 * SPI 的性能缺陷
 * Java 原生的 SPI 是通过 ClassLoader 在 CLASSPATH 中搜索 META-INF/services/ 下 SPI 配置文件，
 * 然后读取配置文件中的内容，所以需要解析 JAR 文件（Android 平台是解析 APK），
 * 而这个过程需要遍历整个 JAR/APK 中所有的条目，因此非常耗时（当年就被它坑得很惨）
 *
 * 优化：
 * 定义一个ServiceRegistry，包装ServiceLoader的功能，将生成的实现类缓存起来
 *
 * 实例：
 *
 * 调用部分 {@link com.yy.JavaExampleApp#main(java.lang.String[])}
 *
 * 代码片段：
 * ServiceLoader<CustomResourceLoader> services = ServiceLoader.load(CustomResourceLoader.class);
 * services.forEach(o -> System.out.println(o.toString()));
 *
 * 配置：
 * META-INF/services下创建接口的全限定名称
 * 举例：
 * 名称：com.yy.example.serviceloader.CustomResourceLoader
 * 文件中的内容：接口实现类的全限定名称
 * com.yy.example.serviceloader.impl.FileResourceLoader
 * com.yy.example.serviceloader.impl.NetResourceLoader
 *
 * 参考：https://juejin.cn/post/6867735071827165198
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-22 at 18:13
 */
package com.yy.example.serviceloader;