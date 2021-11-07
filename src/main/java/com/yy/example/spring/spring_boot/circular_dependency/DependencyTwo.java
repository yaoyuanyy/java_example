package com.yy.example.spring.spring_boot.circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-08-18 at 18:13
 */
@Service
public class DependencyTwo {

    @Autowired
    private DependencyOne dependencyOne;

    public void testTwo(){
        System.out.println("method testTwo");
    }
}
