package com.yy.config;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseObj errorHandle(FullHttpRequest request, FullHttpResponse response){
        log.error("request uri:{} response status:{}", request.uri(), response.status());
        return new ResponseObj(AppCode.ERROR, "");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
