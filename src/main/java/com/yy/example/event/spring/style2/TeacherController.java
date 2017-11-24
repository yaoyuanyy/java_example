package com.yy.example.event.spring.style2;

import com.yy.example.event.Teacher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午5:03
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController implements ApplicationEventPublisherAware{

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("applicationEventPublisher init:" + applicationEventPublisher);
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @RequestMapping("/get")
    public String get(){
        Teacher t = new Teacher();
        t.setId(22l);
        t.setName("ll");
        TeacherEvent event = new TeacherEvent(this, t);
        applicationEventPublisher.publishEvent(event);

        return "success";
    }

}
