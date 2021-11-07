package com.yy.annotation;

import com.yy.example.spring.custom_spring.custom2.sub2.CustomImportBeanDefinitionRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/15 at 下午7:04
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(value = {CustomImportBeanDefinitionRegister.class})
public @interface CustomClass2IOC {

    Class<?>[] targets() default {};
}
