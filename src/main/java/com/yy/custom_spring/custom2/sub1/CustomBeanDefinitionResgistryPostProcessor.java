package com.yy.custom_spring.custom2.sub1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * Description: 自定义 BeanDefinitionRegistryPostProcessor用于实现自己的bean definition注册逻辑。如可以按某个包注册，按某个注解注册
 * <p>
 *     BeanDefinitionRegistryPostProcessor 接口可以看作是BeanFactoryPostProcessor和ImportBeanDefinitionRegistrar的功能集合，既可以获取和修改BeanDefinition的元数据，也可以实现BeanDefinition的注册、移除等操作。
 * </p>
 * <pre>
 *     refer to http://elim.iteye.com/blog/2394038
 * </pre>
 *
 * Created by skyler on 2018/9/29 at 下午5:09
 */
@Slf4j
public class CustomBeanDefinitionResgistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

//    /**
//     * 重载方法1 注册指定的类到spring ioc中
//     * @param registry
//     * @throws BeansException
//     */
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        if(!registry.containsBeanDefinition(Hello.class.getName())){
//            BeanDefinition beanDefinition = new RootBeanDefinition(Hello.class);
//            registry.registerBeanDefinition(Hello.class.getName(), beanDefinition);
//        }
//    }

    /**
     * 重载方法2 加载com.yy包及子包下非接口且非抽象类的类。使用ClassPathScanningCandidateComponentProvider定义加载package下类的规则
     * @param registry
     * @throws BeansException
     */
//    @Override
////    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
////        boolean useDefaultFilters = false;
////        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
////        TypeFilter typeFilter = new TypeFilter() {
////            @Override
////            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
////                if(metadataReader.getClassMetadata().isConcrete()){
////                    return true;
////                }
////                return false;
////            }
////        };
////        // 获取指定规则的类
////        provider.addIncludeFilter(typeFilter);
////
////        // 排除指定规则的类
////        provider.addExcludeFilter(new TypeFilter() {
////            @Override
////            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
////
////                if(metadataReader.getClassMetadata().getClassName().contains("TestController")){
////                    return true;
////                }
////                return false;
////            }
////        });
////
////        // 排除指定注解的类
////        //provider.addExcludeFilter(new AnnotationTypeFilter(Component.class));
////
////        String scanPackage = "com.yy.rest";
////        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(scanPackage);
////
////        for (BeanDefinition beanDefinition : beanDefinitions) {
////            log.info("  ----  com.yy下的加载类为:{}",beanDefinition.getBeanClassName());
////            if(!registry.containsBeanDefinition(beanDefinition.getBeanClassName())
////                    && !registry.containsBeanDefinition(StringUtils.uncapitalize(StringUtils.unqualify(beanDefinition.getBeanClassName())))) {
////                registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
////            }
////        }
////    }

    /**
     * 重载方法3 加载com.yy包及子包下拥有指定注解的类。使用ClassPathScanningCandidateComponentProvider定义加载package下类的规则
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("into CustomBeanDefinitionResgistryPostProcessor.postProcessBeanDefinitionRegistry method");

        BeanDefinition singleBeanDefinition = new RootBeanDefinition(Hello.class);
        registry.registerBeanDefinition(Hello.class.getName(), singleBeanDefinition);

        boolean useDefaultFilters = false;
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);

        provider.addIncludeFilter(new AnnotationTypeFilter(Component.class));

        String scanPackage = "com.yy.rest";
        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(scanPackage);

        for (BeanDefinition beanDefinition : beanDefinitions) {
            log.info("  ----  com.yy下的加载类为:{}",beanDefinition.getBeanClassName());
            if(!registry.containsBeanDefinition(beanDefinition.getBeanClassName())
                    && !registry.containsBeanDefinition(StringUtils.uncapitalize(StringUtils.unqualify(beanDefinition.getBeanClassName())))) {
                registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
            }
        }
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        log.info("into CustomBeanDefinitionResgistryPostProcessor.postProcessBeanFactory method");
    }

}
