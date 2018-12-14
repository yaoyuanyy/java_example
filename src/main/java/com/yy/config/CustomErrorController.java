package com.yy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
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
@Slf4j
public class CustomErrorController implements ErrorController {

    private static final String PATH="/error";

    @RequestMapping(PATH)
    public ResponseObj errorHandle(HttpServletRequest request, HttpServletResponse response){
        log.error("request uri:{} response status:{}", request.getRequestURL(), response.getStatus());
        return new ResponseObj(AppCode.ERROR, "");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
