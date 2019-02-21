package com.yy.custom_spring.custom7_utils.annotation;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/19 at 上午7:48
 */
//@CustomPostMapping(path = "/c")
public class CController extends PController{

    @RequestMapping("/c_method")
    public void cothed(){

    }
}
