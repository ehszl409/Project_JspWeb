package com.park.reservation.domain.pay.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PayDetailReqDto {
	private int id;
	private int userId;
	private int storeId;
	private String payAmount;
	private String buyer_email;
	private String buyer_name;
	private String buyer_tel;
	private String buyer_addr;
	private String pay_method;
	private String pickup;
	private String message;
	private String name;
	private String roadAddress;
	private String address;
	private String phone;
	private Timestamp createDate;

}
