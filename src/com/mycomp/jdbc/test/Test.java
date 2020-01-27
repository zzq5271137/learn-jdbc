package com.mycomp.jdbc.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import com.mycomp.jdbc.domain.User;

/*
 * Class字节码类与内省
 */

class ClassTest {
    public Class c;

    public ClassTest(Class c) {
        this.c = c;
    }
}

public class Test {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, IntrospectionException,
            IllegalArgumentException, InvocationTargetException {
        ClassTest classTest = new ClassTest(User.class);
        User user = (User) classTest.c.newInstance();
        user.setUsername("zzq");
        user.setPassword("1234");
        System.out.println(user);
        System.out.println("分割===================");

        /*
         * 内省: 查看和操作JavaBean的属性
         */
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo
                .getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors) {
            System.out.println(pd.getName());
            System.out.println(pd.getReadMethod());
            System.out.println(pd.getWriteMethod());
            pd.getWriteMethod().invoke(user, "111");
            System.out.println(user);
            System.out.println("================");
        }
    }
}
