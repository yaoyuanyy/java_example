package com.yy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "skyler.common")
public class SignConfig {

    private String privateKey;

    private String publicKey;

    private String targetCallbackUrl;

    private List<String> excludeUrls;

}
