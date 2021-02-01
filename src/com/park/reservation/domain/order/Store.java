package com.park.reservation.domain.order;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Store {
	private int id;
	private int userId;
	private String name;
	private String roadAddress;
	private String address;
	private String phone;
	private Timestamp createDate;
}
