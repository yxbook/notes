//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iamlook.config;

import java.util.Map;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

/**
 * 驼峰Map返回驼峰
 */
public class MybatisMapWrapper extends MapWrapper {
    public MybatisMapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }

    public String findProperty(String name, boolean useCamelCaseMapping) {
        return useCamelCaseMapping && !StringUtils.isCamel(name) ? StringUtils.underlineToCamel(name) : name;
    }
}
