package com.yy.custom_spring.custom7_utils.annotation;

import com.yy.annotation.CustomClass2IOC;
import com.yy.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Description: AnnotatedElementUtils AnnotationUtils 联系使用及两者区别
 *
 * refer to https://www.cnblogs.com/hujunzheng/p/9790588.html
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/18 at 下午11:20
 */
@Slf4j
public class AnnotationUtilsAndAnnotatedElementUtilsTest {

    public static void main(String[] args) {
        Annotation annotation = getAnnotation(AppConfig.class,CustomClass2IOC.class);
        System.out.println(annotation.annotationType().getCanonicalName());

        //diff_getAnnotation_and_findAnnotation_method();
        //diffAnnotationUtilsAndAnnotatedElementUtils();
        getAnnotationOnMethod(CController.class);
    }

    public static Annotation getAnnotation(AnnotatedElement element, Class clazz){
        return AnnotatedElementUtils.findMergedAnnotation(element, clazz);
    }


    /**
     *
     * <em>difference</em> between getAnnotation() and findAnnotation()
     *
     * <p>
     *     getAnnotation：只在当前类中找，没找到就没找到
     *     findAnnotation：如果当前类中没找到，则去当前类的注解，接口，父类找
     * </p>
     *
     * <pre>
     * 需要的示例代码：
     *
     * {@literal @}RequestMapping("/p")
     *  public class PController {
     *   {@literal @}RequestMapping("p_method")
     *    public void pMothed(){
     *
     *    }
     *  }
     *
     *  public class CController extends PController{
     *    public void cothed(){
     *
     *    }
     *  }
     * </pre>
     */
    public static void diff_getAnnotation_and_findAnnotation_method() {
        System.out.println(" --- getAnnotation 与 findAnnotation的不同点");
        RequestMapping annotation = AnnotationUtils.getAnnotation(CController.class, RequestMapping.class);
        System.out.println("AnnotationUtils.getAnnotation() CController:"+annotation);

        RequestMapping annotation2 = AnnotationUtils.findAnnotation(CController.class, RequestMapping.class);
        System.out.println("AnnotationUtils.findAnnotation() CController:"+annotation2);
    }

    /**
     *
     * difference between {@link AnnotationUtils} and {@link AnnotatedElementUtils}
     *
     * <pre>
     * 需要的示例代码：
     *
     * {@literal @}RequestMapping("/p")
     *  public class PController {
     *   {@literal @}RequestMapping("p_method")
     *    public void pMothed(){
     *
     *    }
     *  }
     * {@literal @}CustomPostMapping(path = "/c")
     *  public class CController extends PController{
     *    public void c_mothed(){
     *
     *    }
     *  }
     * </pre>
     */
    public static void diffAnnotationUtilsAndAnnotatedElementUtils() {
        System.out.println(" --- AnnotationUtils 与 AnnotatedElementUtils的不同点");
        System.out.println("AnnotationUtils.findAnnotation() CController:"+AnnotationUtils.findAnnotation(CController.class, RequestMapping.class));
        System.out.println("AnnotatedElementUtils.findMergedAnnotation() CController:"+AnnotatedElementUtils.findMergedAnnotation(CController.class, RequestMapping.class));
    }

    /**
     *
     * 根据Class找出带有特定注解的method map(包含父类的符合的方法) 参考：EventListenerMethodProcessor.processBean()方法
     *
     * <pre>
     * 需要的示例代码：
     *
     * {@literal @}RequestMapping("/p")
     *  public class PController {
     *   {@literal @}RequestMapping("p_method")
     *    public void pMothed(){
     *
     *    }
     *  }
     *
     *  public class CController extends PController{
     *   {@literal @}RequestMapping("c_method")
     *    public void c_mothed(){
     *
     *    }
     *  }
     * </pre>
     * @param targetType
     */
    public static void getAnnotationOnMethod(Class targetType){
        Map<Method, RequestMapping> annotatedMethods = null;
        try {
            annotatedMethods = MethodIntrospector.selectMethods(targetType,
                    new MethodIntrospector.MetadataLookup<RequestMapping>() {
                        @Override
                        public RequestMapping inspect(Method method) {
                            return AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
                        }
                    });
            System.out.println(annotatedMethods);
        }catch (Throwable ex) {
            log.debug("Could not resolve methods for bean with name '" + targetType.getName() + "'", ex);

        }
    }

}
