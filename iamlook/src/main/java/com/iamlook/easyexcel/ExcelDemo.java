package com.iamlook.easyexcel;

import lombok.Data;

import java.util.Set;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-11-25下午1:13
 */
@Data
public class ExcelDemo {

    private String code;

    private String pcode;

    private String name;

    private String fullName;

    private boolean jgzh;

    private Set<ExcelDemo> children;

}