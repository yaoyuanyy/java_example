package com.yy.example.event.spring.style2;

import com.yy.example.event.Teacher;
import org.springframework.context.ApplicationEvent;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午4:14
 */
public class TeacherEvent extends ApplicationEvent {

    private Teacher teacher;

    public TeacherEvent(Object source, Teacher teacher) {
        super(source);
        this.teacher = teacher;
    }

    public Long getId(){
        System.out.println(source.toString());
        return teacher.getId();
    }
}
