package com.yy.rest.sign_verify;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yy.config.SignConfig;
import com.yy.util.HttpUtils;
import com.yy.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/29 at 上午10:01
 */
@Service
@Slf4j
public class PersonService {

    @Resource
    private PersonDao dao;

    @Autowired
    private SignConfig signConfig;

    public List getBankAccount(final Long id) {
        final Person person = dao.getPerson(id);
        final Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", person.id);
        paramMap.put("name", person.getName());
        paramMap.put("userId", 1111);
        paramMap.put("tradeNo", UUID.randomUUID().toString());
        paramMap.put("sign", SignUtil.sign(paramMap, signConfig.getPrivateKey()));

        try {
            final HttpUtils.Response response = HttpUtils.post(signConfig.getTargetCallbackUrl(), paramMap);
            log.info("response code:{}, body:{}", response.getCode(), response.getBody());
            final ResponseResult<String> responseResult = JSON.parseObject(response.getBody(), new TypeReference<ResponseResult<String>>() {
            });
            if (responseResult.getCode() == 0) {
                // 修改记录表状态为success
            } else {
                // 修改记录重试次数+1
            }

        } catch (final IOException e) {
            throw new RuntimeException("error", e);
        }
        return null;
    }
}
