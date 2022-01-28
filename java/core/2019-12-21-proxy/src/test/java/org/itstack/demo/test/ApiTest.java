package org.itstack.demo.test;

import org.itstack.demo.cglib.CglibProxy;
import org.itstack.demo.jdk.reflect.JDKProxy;
import org.itstack.demo.service.IUserService;
import org.itstack.demo.service.UserService;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ssqswyf
 * @date 2022/1/28
 */
public class ApiTest {

    @Test
    public void test_proxy_jdk() throws Exception {

        IUserService proxy = (IUserService) JDKProxy.getProxy(Class.forName("org.itstack.demo.service.IUserService"));
        String userName = proxy.queryUserNameById("10001");
        System.out.println(userName);

        String name = "ProxyUserService";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{IUserService.class});

        // 输出字节码文件
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(name+".class");
            System.out.println((new File("")).getAbsolutePath());
            out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test_proxy_cglib() {
        CglibProxy cglibProxy = new CglibProxy();
        UserService userService = (UserService) cglibProxy.newInstance(new UserService());
        String userName = userService.queryUserNameById("10001");
        System.out.println(userName);
    }


}
