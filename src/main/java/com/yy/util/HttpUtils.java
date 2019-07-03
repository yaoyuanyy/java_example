package com.yy.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    /**
     * HTTP Post请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static Response post(final String url, final Map<String, ? extends Object> paramMap) throws IOException {

        final FormBody.Builder formBuilder = new FormBody.Builder();

        for (final Entry<String, ? extends Object> entry : paramMap.entrySet()) {
            formBuilder.add(entry.getKey(), String.valueOf(entry.getValue()));
        }

        final Request request = new Request.Builder().header("Referer", "http://www.skyler.com").url(url).post(formBuilder.build()).build();

        final okhttp3.Response response = HTTP_CLIENT.newCall(request).execute();

        return new Response(response.code(), response.body().string());
    }

    /**
     * Http Get 请求
     *
     * @param url
     * @param paramMap
     * @return
     * @throws IOException
     */
    public static Response get(final String url, final Map<String, ?> paramMap) throws IOException {
        final HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl == null) {
            throw new RuntimeException("invalid url");
        }

        final HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();
        for (final Entry<String, ?> entry : paramMap.entrySet()) {
            httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
        }

        final Request request = new Request.Builder().url(httpUrlBuilder.build().url()).get().build();

        final okhttp3.Response response = HTTP_CLIENT.newCall(request).execute();

        return new Response(response.code(), response.body().string());
    }

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Response {
        private int code;
        private String body;
    }

}
