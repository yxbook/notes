package com.iamlook.model;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Description 检测单位(人员)
 * @Author zl
 * @Date 19-5-28 下午2:14
 * @Version 1.0
 **/

@Data
public class UserBean {

    private String id;  //检测员id

    private String name; // 检测员姓名

    @Column(name = "emp_num")
    private String empNum; // 员工号

    private String position; // 职位

    @Column(name = "dept_id")
    private String deptId; // 所属部门id

    @Column(name = "dept_name")
    private String deptName; // 所属部门名称

    private String phone; // 手机号

    @Column(name = "org_id")
    private String orgId; // 机构id

    @Column(name = "org_name")
    private String orgName; // 机构名称

}
