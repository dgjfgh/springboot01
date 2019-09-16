package com.demo;

/**
 * Created by majianghua on 2019/9/2.
 */
public class MyHello implements MyInterface{
    @Override
    public void sayHello(String name) {
        System.out.println("hello"+name);
    }
}