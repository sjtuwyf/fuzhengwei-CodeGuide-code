package org.itstack.demo.jdk.reflect;

import org.itstack.demo.jdk.util.ClassLoaderUtils;

import java.lang.reflect.Proxy;

/**
 * @author ssqswyf
 * @date 2022/1/28
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass) throws Exception {
        JDKInvocationHandler handler = new JDKInvocationHandler();
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }

}
