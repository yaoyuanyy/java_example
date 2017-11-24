package com.yy.example.event.spring.style2;

import com.yy.example.event.spring.style1.StudentEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/11/24 at 下午4:21
 */
@Component
public class TeacherListener implements ApplicationListener<TeacherEvent> {

    @Override
    public void onApplicationEvent(TeacherEvent event) {
        Long teacherId = event.getId();
        System.out.println("teacherId:" + teacherId);
    }
}
