package org.itstack.demo.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ssqswyf
 * @date 2022/1/28
 */
public class JDKInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return "我被JDKProxy代理了";
    }
}
