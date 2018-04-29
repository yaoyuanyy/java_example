package com.yy.rest.sign_verify;

import com.yy.config.SignConfig;
import com.yy.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/12/4 at 下午6:44
 */
@RestController
public class PersonController {


    @Autowired
    private SignConfig signConfig;

    @Autowired
    private PersonService personService;

    /**
     * 通过用户id调用银行的服务，此时是consumer，so生成sign去调用provider
     *
     * @param id
     * @return
     */
    public String getBankAccount(final Long id) {
        final List list = personService.getBankAccount(id);
        return null;
    }

    /**
     * 作为provider,供其他服务调用
     *
     * @param id
     * @param name
     * @param request
     * @return
     */
    @PostMapping("/update_name")
    public String updateName(final Long id, final String name, final HttpServletRequest request) {

        signVerify(request);
        // 修改name
        System.out.println("ok");

        return "success";
    }

    private void signVerify(final HttpServletRequest request) {
        final boolean verifySuccess = SignUtil.verify(getParamMap(request),
                this.signConfig.getPublicKey());
        if (!verifySuccess) {
            throw new CustomException(ErrorCodeEnum.ERROR);
        }
    }


    private Map<String, String> getParamMap(final HttpServletRequest request) {
        final Map<String, String> paramMap = new HashMap<>();

        final Enumeration<String> keys = request.getParameterNames();

        while (keys.hasMoreElements()) {
            final String name = keys.nextElement();
            paramMap.put(name, request.getParameter(name));
        }

        return paramMap;
    }
}


