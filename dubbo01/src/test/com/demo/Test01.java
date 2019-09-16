package com.demo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by majianghua on 2019/8/29.
 */
public class Test01 {
    @Test
    public void test01(){
        System.out.println(1516.36/31.103481*7.154);
        MyInterface instance = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                method.invoke(MyHello.class.newInstance(), args);
                System.out.println("after");
                return null;
            }
        });

        instance.sayHello("asd");
    }

}