package com.yy.example.spring.custom_spring.custom5;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/15 at 下午7:55
 */
@Slf4j
public class InstantiationService {

    private Long id;
    private String name;

    public InstantiationService(){
        log.info(" --- class:{} constructor", this.getClass());
    }

    protected InstantiationService(Long id) {
        log.info(" --- class:{} constructor param id", this.getClass());
        this.id = id;
    }

    protected InstantiationService(Long id, String name) {
        log.info(" --- class:{} constructor param id", this.getClass());
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        log.info(" --- class:{} setId:{}", this.getClass(), id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initMethod(){
        id = 200L;
        log.info(" --- class:{} initMethod", this.getClass());

    }

    public void sayHello(){
        log.info("say hello");
    }
}
