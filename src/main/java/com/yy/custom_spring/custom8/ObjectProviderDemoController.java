package com.yy.custom_spring.custom8;

import com.yy.config.ResponseObj;
import com.yy.service.IPersonService;
import com.yy.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Description: 使用ObjectProvider进行隐式注入
 * <p></p>
 * <pre>
 *
 *   refer to https://dzone.com/articles/optional-dependency-injection-with-spring
 * </pre>
 * <p>
 * Created by skyler on 2018/10/21 at 下午11:11
 */
@RestController
@RequestMapping("/person")
public class ObjectProviderDemoController {

    private IPersonService personService;

    public ObjectProviderDemoController(ObjectProvider<IPersonService> personServiceObjectProvider) {
        System.out.println(" --- PersonController contructor ObjectProvider");
        this.personService = personServiceObjectProvider.getIfAvailable();
        if(Objects.isNull(personService)){
            System.out.println(" --- PersonController ObjectProvider-->personService is null");
            personService = new PersonServiceImpl();
        }
    }

    @RequestMapping("/query_one")
    public ResponseObj queryOne() {
        return ResponseObj.success(personService.getById(1L));
    }

}
