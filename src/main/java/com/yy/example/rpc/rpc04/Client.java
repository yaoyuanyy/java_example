package com.yy.example.rpc.rpc04;

import com.yy.example.rpc.common.IUserService;
import com.yy.example.rpc.rpc03.Stub;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService userService = Stub.getStub();
        System.out.println(userService.findUserById(123));
    }
}