package com.iamlook.jpa;

import cn.com.larunda.entity.user.TenantUser;
import cn.com.larunda.enumeration.HandOverEnum;
import cn.com.larunda.enumeration.OrderEnum;
import cn.com.larunda.enumeration.PayEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/***************************************
 * @Project cabinet-java
 * @Description  快递订单
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************/
@Data
@Entity
@Table(name = "express_order")
@TableName(value = "express_order")
@ToString(callSuper = true)
public class ExpressOrder extends BaseEntity {
	/**
	 * 用户ID
	 */
	@TableField(value = "user_id", el = "tenantUser.id")
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private TenantUser tenantUser;
	/**
	 * 收件人地址
	 */
	@TableField(value = "receipt_id", el = "receiptAddress.id")
	@OneToOne
	@JoinColumn(name = "receipt_id")
	private ExpressAddress receiptAddress;
	/**
	 * 寄件人地址
	 */

	@TableField(value = "send_id", el = "sendAddress.id")
	@OneToOne
	@JoinColumn(name = "send_id")
	private ExpressAddress sendAddress;

	/**
	 * 快递公司
	 */
	@TableField(value = "company_id", el = "company.id")
	@OneToOne
	@JoinColumn(name = "company_id")
	private ExpressCompany company;

	/**
	 * 是否当面交易 0否1是
	 */
	@Column(name = "is_trade")
	private Byte isTrade;

	/**
	 * 约定当面交易开始时间
	 */
	@Column(name = "f_time")
	private LocalDateTime fTime;

	/**
	 * 约定当面交易结束时间
	 */
	@Column(name = "t_time")
	private LocalDateTime tTime;

	/**
	 * 是否加急 0否1是
	 */
	@Column(name = "is_urgent")
	private Byte isUrgent;

	/**
	 * 加急费
	 */
	@Column(name = "urgent_fee")
	private BigDecimal urgentFee;

	/**
	 * 是否需要包装 0否1是
	 */
	@Column(name = "is_pack")
	private Byte isPack;

	/**
	 * 包装费
	 */
	@Column(name = "pack_fee")
	private BigDecimal packFee;
	/**
	 * 是否需要信封0否1是
	 */
	@Column(name = "is_envelope")
	private Byte isEnvelope;

	/**
	 * 保价金额
	 */
	@Column(name = "insurance_fee")
	private BigDecimal insuranceFee;

	/**
	 * 预计收保价金额 = 费率XX%
	 */
	@Column(name = "budget_fee")
	private BigDecimal budgetFee;

	/**
	 * 订单状态 枚举
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderEnum status;

	/**
	 * 与服务端交接状态 枚举
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "hand_over")
	private HandOverEnum handOver;
	/**
	 * 4位寄件码
	 */
	@Column(name = "send_code")
	private String sendCode;

	/**
	 * 快递费
	 */
	@Column(name = "express_fee")
	private BigDecimal expressFee;

	/**
	 * 支付方式
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "pay_way")
	private PayEnum payWay;

	/**
	 * 实付金额
	 */
	@Column(name = "pay_price")
	private BigDecimal payPrice;

	/**
	 * 订单编号
	 */
	private String code;
	/**
	 * 运单号
	 */
	@Column(name = "bill_num")
	private String billNum;
	/**
	 * 订单提交时间
	 */
	@Column(name = "s_time")
	private LocalDateTime sTime;
	/**
	 * 订单结束或取消时间
	 */
	@Column(name = "e_time")
	private LocalDateTime eTime;

	/**
	 * 订单支付时间
	 */
	@Column(name = "p_time")
	private LocalDateTime pTime;



}
