package org.itstack.demo.jdk.util;

/**
 * @author ssqswyf
 * @date 2022/1/28
 */
public class ClassLoaderUtils {
    public static ClassLoader getCurrentClassLoader() {

        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassLoaderUtils.class.getClassLoader();
        }

        return cl;
    }
}
