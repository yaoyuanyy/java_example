package com.yy.example.spring.reactor;

import com.yy.config.ResponseObj;
import com.yy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
@Slf4j
@RequestMapping("/reactor-user")
public class ReactiveUserController {

    //@Autowired
    private IUserService userService;

    private static int i = 0;

//    @RequestMapping("/hello")
//    public Mono<String> hello(final Person person) {
//
//
//        return Mono.just("success");
//    }
//
//    @RequestMapping("/test")
//    public Mono<ServerResponse> test(ServerRequest serverRequest) {
//        return ServerResponse.ok().body(BodyInserters.fromObject(new Person("f", "l")));
//    }
    @RequestMapping("/hello")
    public void test(){
        try {
            userService.getById(11L);
            //System.out.println(person.getFirstName());
        } catch (Exception e) {
            log.error("ERROR ", e);
            String season = e.getMessage();
            System.out.println(season);
            if (!StringUtils.isEmpty(season)) {
                System.out.println("k");
            }
        }
    }


    @RequestMapping("/query_one")
    public ResponseObj queryOne() {
        return ResponseObj.success(userService.getById(1L));
    }
}


