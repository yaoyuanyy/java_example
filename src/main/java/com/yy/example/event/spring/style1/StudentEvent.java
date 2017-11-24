package com.yy.example.event.spring.style1;

import com.yy.example.event.Student;
import org.springframework.context.ApplicationEvent;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午4:14
 */
public class StudentEvent extends ApplicationEvent {

    private Student student;

    public StudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }

    public Long getId(){
        System.out.println(source.toString());
        return student.getId();
    }
}
