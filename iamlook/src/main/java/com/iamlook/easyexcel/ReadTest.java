package com.iamlook.easyexcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-11-25下午1:07
 */
public class ReadTest{

    @Test
    public void testReadExcel(){
        String fileName = "/home/sddt/zm/Data-X/test.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, ExcelDemo.class, new DemoDataListener()).sheet().doRead();

    }
}