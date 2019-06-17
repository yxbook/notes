/*
package com.iamlook.jpa;

import cn.com.larunda.entity.content.Document;
import cn.com.larunda.entity.user.TenantUser;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

*/
/***************************************
 * @Project cabinet-java
 * @Description 寄快递身份验证信息
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************//*

@Data
@Entity
@Table(name = "express_verify")
@TableName(value = "express_verify")
@ToString(callSuper = true)
public class ExpressVerify extends BaseEntity {

	*/
/**
	 * 用户ID
	 *//*

	@TableField(value = "user_id", el = "tenantUser.id")
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private TenantUser tenantUser;

	*/
/**
	 * 寄快递协议
	 *//*

	@TableField(value = "doc_id", el = "document.id")
	@OneToOne
	@JoinColumn(name = "doc_id", referencedColumnName = "id")
	private Document document;

	*/
/**
	 * 身份证号码
	 *//*

	@Column(name = "id_number")
	private String idNumber;

	*/
/**
	 * 身份证对应姓名
	 *//*

	private String name;

}
*/
