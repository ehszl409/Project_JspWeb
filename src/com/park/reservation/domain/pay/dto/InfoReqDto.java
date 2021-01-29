package com.park.reservation.domain.pay.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class InfoReqDto {
	private int id;
	private int userId;
	private String payName;
	private String payAmount;
	private String buyer_email;
	private String buyer_name;
	private String buyer_tel;
	private String buyer_addr;
	private String pay_method;
	private String merchant_uid;
	private String pg_tid;
	private String imp_uid;
	private String paid_at;
	private String pickup;
	private String message;
	private Timestamp createDate;
}
