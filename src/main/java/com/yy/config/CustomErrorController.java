package com.yy.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/7/16 at 下午10:54
 */
@RestController
public class CustomErrorController implements ErrorController{

    private static final String PATH="/error";

    @RequestMapping(PATH)
    public String errorHandle(HttpServletRequest request, HttpServletResponse response){
        System.out.println("cuowu");
        return "lll";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
