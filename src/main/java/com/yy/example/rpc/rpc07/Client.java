package com.yy.example.rpc.rpc07;

import com.yy.example.rpc.common.IProductService;

public class Client {
    public static void main(String[] args) throws Exception {
        IProductService productService = (IProductService)Stub.getStub(IProductService.class);
        System.out.println(productService.findProductById(123));
    }
}