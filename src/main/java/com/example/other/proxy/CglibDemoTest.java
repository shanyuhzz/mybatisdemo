package com.example.other.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDemoTest implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Execute pre.");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("Execute after.");

        return obj;
    }

    public static void main(String[] args) {

    }
}
