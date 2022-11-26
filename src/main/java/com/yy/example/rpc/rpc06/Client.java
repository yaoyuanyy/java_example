package com.yy.example.rpc.rpc06;

import com.yy.example.rpc.common.IUserService;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService userService = (IUserService)Stub.getStub(IUserService.class);
        System.out.println(userService.findUserById(123));
    }
}