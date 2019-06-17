/*
package com.iamlook.jpa;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

*/
/***************************************
 * @Project cabinet-java
 * @Description 快递公司
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************//*

@Data
@Entity
@Table(name = "express_company")
@TableName(value = "express_company")
@ToString(callSuper = true)
public class ExpressCompany extends BaseEntity {

	*/
/**
	 * 公司编码
	 *//*

	private String code;

	*/
/**
	 * 公司名称
	 *//*

	private String name;

	*/
/**
	 * 费率
	 *//*

	private Double rate;

	*/
/**
	 * 状态
	 *//*

	private Integer status;

}
*/
