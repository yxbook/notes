package com.iamlook.config;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

import java.util.Map;

/***************************************
 * @Project notes
 * @Description 驼峰Map返回驼峰
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************/
public class MapWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return object != null && object instanceof Map;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        return new MybatisMapWrapper(metaObject,(Map)object);
    }
}
