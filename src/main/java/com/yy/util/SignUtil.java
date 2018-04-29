package com.yy.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignUtil {

    public static String sign(final Map<String, ? extends Object> params, final String privateKey) {
        return RSAUtil.sign(getParamString(params), privateKey, "UTF-8");
    }

    public static boolean verify(final Map<String, ? extends Object> params, final String publicKey) {
        final String sign = (String) params.remove("sign");
        return RSAUtil.verify(getParamString(params), sign, publicKey, "UTF-8");
    }

    public static String getParamString(final Map<String, ? extends Object> params) {
        final List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        final StringBuilder kvs = new StringBuilder();
        if (!keys.isEmpty()) {
            for (final String key : keys) {
                kvs.append(key).append("=").append(params.get(key)).append("&");
            }
            kvs.setLength(kvs.length() - 1);
        }
        return kvs.toString();
    }

}
