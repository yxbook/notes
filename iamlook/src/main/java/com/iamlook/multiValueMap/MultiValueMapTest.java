package com.iamlook.multiValueMap;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-9-2下午2:14
 */
public class MultiValueMapTest {

    @Test
    public void testMultiValueMap(){

        MultiValueMap mailMap = new MultiValueMap();
        mailMap.put("number", "1");
        mailMap.put("number", "30");
        mailMap.put("name", "wang");
        mailMap.put("card", "12344");
        mailMap.put("card", "65432");
        System.out.println(mailMap.get("card"));
        System.out.println(JSON.toJSONString(mailMap));

    }

}