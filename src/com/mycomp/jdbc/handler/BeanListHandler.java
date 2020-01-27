package com.mycomp.jdbc.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * 通用的结果集处理器 (处理多条记录, 也就是一个list)
 */

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    private Class<T> classType;

    public BeanListHandler(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            T beanObject = classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(classType,
                    Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Object val = rs.getObject(pd.getName());
                pd.getWriteMethod().invoke(beanObject, val);
            }
            list.add(beanObject);
        }
        return list;
    }
}
