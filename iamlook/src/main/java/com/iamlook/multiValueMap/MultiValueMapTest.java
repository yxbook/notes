package com.iamlook.multiValueMap;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

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
        List<String> aa = (List<String>) mailMap.get("card");
        System.out.println(mailMap.get("card"));
        System.out.println(aa);

        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00"));


    }

}