package com.dp2.proxy1;

import org.springframework.cglib.proxy.Proxy;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/6/21.
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonDao pDao = new PersonDaoImpl();
        PersonHandler handler = new PersonHandler(pDao);

        PersonDao proxy = (PersonDao) Proxy.newProxyInstance(pDao.getClass().getClassLoader(), pDao.getClass().getInterfaces(), handler);
        proxy.say();
        createProxyClassFile();
    }


    public static void createProxyClassFile()
    {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{PersonDao.class});
        try
        {
            FileOutputStream out = new FileOutputStream( name + ".class" );
            out.write( data );
            out.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

}
