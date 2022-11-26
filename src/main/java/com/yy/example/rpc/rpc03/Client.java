package com.yy.example.rpc.rpc03;

import com.yy.example.rpc.common.IUserService;
import com.yy.example.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        IUserService userService = Stub.getStub();
        System.out.println(userService.findUserById(123));
    }
}