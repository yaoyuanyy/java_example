package com.yy.example.event.spring.style1;

import com.yy.example.event.Student;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午4:21
 */
@Component
public class StudentListener implements ApplicationListener<StudentEvent> {

    @Override
    public void onApplicationEvent(StudentEvent event) {
        Long studentId = event.getId();
        System.out.println("studentId:" + studentId);
    }

    //@Async
    @EventListener(classes = Student.class)
    public void onStudentNameEvent(Student s){
        String name = s.getName();
        System.out.println(name);
    }

}
