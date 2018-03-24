package com.ljd.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by user34 on 2018/3/24.
 */
public class HomeLink implements InvocationHandler {
    private Person target;

    Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
        method.invoke(target, args);
        System.out.println("我是链家，已经找完了..");
        return null;
    }
}
