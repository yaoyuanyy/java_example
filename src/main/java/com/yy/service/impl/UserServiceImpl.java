package com.yy.service.impl;

import com.yy.model.User;
import com.yy.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Description:
 * <p></p>
 * <pre>
 *
 *   NB.
 * </pre>
 * <p>
 * Created by skyler on 2018/10/10 at 下午5:38
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService{

    @Override
    public User getById(Long id) {
        log.info("hello userServiceImpl");
        return new User();
    }
}
