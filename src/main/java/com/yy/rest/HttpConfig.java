package com.yy.rest;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2019-03-25 at 16:13
 */
@Configuration
public class HttpConfig {


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();

        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        byteArrayHttpMessageConverter.setSupportedMediaTypes(
                Lists.newArrayList(new MediaType("application", "pdf", UTF_8)
                ,new MediaType("application", "octet-stream")));

        converters.add(byteArrayHttpMessageConverter);

        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }
}
