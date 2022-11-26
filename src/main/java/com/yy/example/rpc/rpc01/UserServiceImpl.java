package com.yy.example.rpc.rpc01;

import com.yy.example.rpc.common.IUserService;
import com.yy.example.rpc.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id, "Alice");
    }
}