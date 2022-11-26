package com.yy.example.rpc.rpc04;

import com.yy.example.rpc.common.IUserService;
import com.yy.example.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 但是这里仅仅实现了findByUserId的方法代理，如果要实现其他方法的代理该怎么做呢？
 * 这里就要从协议层做出改进
 *
 * 服务器端也要做出对应处理
 */

public class Stub {
    public static IUserService getStub() {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 8888);

                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                String methodName = method.getName();
                Class[] parametersTypes = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();


                DataInputStream dis = new DataInputStream(s.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                oos.close();
                s.close();
                return user;
            }
        };
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[] {IUserService.class}, h);
        return (IUserService)o;
    }




}
