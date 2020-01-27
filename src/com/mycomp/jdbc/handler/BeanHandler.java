package com.mycomp.jdbc.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

/*
 * 通用的结果集处理器 (处理一条记录)
 */

public class BeanHandler<T> implements IResultSetHandler<T> {

    private Class<T> classType;

    public BeanHandler(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public T handle(ResultSet rs) throws Exception {
        if (rs.next()) {
            T beanObject = this.classType.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(this.classType,
                    Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Object val = rs.getObject(pd.getName());
                pd.getWriteMethod().invoke(beanObject, val);
            }
            return beanObject;
        }
        return null;
    }

}
