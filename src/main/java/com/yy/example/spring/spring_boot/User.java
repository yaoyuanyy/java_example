package com.yy.example.spring.spring_boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * <p>
 * NB.
 * </p>
 * Created by skyler on 2019-07-10 at 11:02
 */
@ConfigurationProperties("user")
@RefreshScope
@Data
public class User {

    private int id;
    private String name;
    private Addr addr;

    @Data
    private class Addr{
        private String street;
    }

}
