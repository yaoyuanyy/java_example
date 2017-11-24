package com.yy.example.event.spring.style1;

import com.yy.example.event.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 参考 http://blog.csdn.net/feicongcong/article/details/76066971
 * <p>
 *      实现ApplicationContextAware，用于引入ApplicationContext，由于bookingService也是spring组件，所以在系统启动的时候，ApplicationContext已经注入。
 * 也可以用如下方式直接注入ApplicationContext
 * </p>
 * <pre>
 *    //@Resource
 *    //private ApplicationContext context;
 * </pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午4:25
 */
@RestController
@RequestMapping("/student")
public class StudentController implements ApplicationContextAware{

    Logger log = LoggerFactory.getLogger(StudentController.class);

//    @Resource
//    private ApplicationContext context;

    private ApplicationContext context;

    @RequestMapping("get")
    public String get(@RequestParam("name") String name){
        log.info("param name: {}", name);

        Student s = new Student();
        s.setId(11l);
        s.setName(name);
        StudentEvent event = new StudentEvent(this, s);

        /**
         * 被StudentListener.onApplicationEvent(event)捕获
         */
        //context.publishEvent(event);

        /**
         * 被StudentListener.onStudentNameEvent(s)捕获
         */
        context.publishEvent(s);

        return "success";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
