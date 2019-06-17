package com.iamlook.jpa;

import cn.com.larunda.entity.user.TenantUser;
import cn.com.larunda.enumeration.AddressType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/***************************************
 * @Project cabinet-java
 * @Description  寄件人收件人信息地址信息
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************/
@Data
@Entity
@Table(name = "express_address")
@TableName(value = "express_address")
@ToString(callSuper = true)
public class ExpressAddress extends BaseEntity {

	/**
	 * 用户ID
	 */
	@TableField(value = "user_id", el = "tenantUser.id")
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private TenantUser tenantUser;
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区
	 */
	private String area;
	/**
	 * 小区
	 */
	private String community;
	/**
	 * 楼层信息(ps： 9号楼)
	 */
	private String floor;

	/**
	 * 楼层单元(ps: 8单元)
	 */
	private String unit;

	/**
	 * 楼层编号(ps: 15层)
	 */
	private String level;

	/**
	 * 门牌号
	 */
	@Column(name = "house_num")
	private String houseNum;
	/**
	 * 是否默认地址 0、否  1、是
	 */
	@Column(name = "is_default")
	private Byte isDefault = 0;

	/**
	 * 详细地址
	 */
	@Column(name = "detail_address")
	private String detailAddress;

	/**
	 * 枚举
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "add_type")
	private AddressType addType;

}
