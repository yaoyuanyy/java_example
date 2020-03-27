package com.yy.rest;

import com.google.common.collect.Lists;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Bean
    public RestTemplate okHttpRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(okHttp3ClientHttpRequestFactory());
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();

        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        byteArrayHttpMessageConverter.setSupportedMediaTypes(
                Lists.newArrayList(
                        new MediaType("application", "pdf", UTF_8),
                        MediaType.APPLICATION_OCTET_STREAM));

        converters.add(byteArrayHttpMessageConverter);

        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }

    @Bean
    public OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory(){
        OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient());
//        okHttp3ClientHttpRequestFactory.setConnectTimeout(5000);
//        okHttp3ClientHttpRequestFactory.setWriteTimeout(10000);
//        okHttp3ClientHttpRequestFactory.setReadTimeout(10000);
        return okHttp3ClientHttpRequestFactory;
    }

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient().newBuilder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
    }
}
