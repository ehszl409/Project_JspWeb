package com.park.reservation.domain.order;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderInfo {
	private int id;
	private int userId;
	private int itemId;
	private Timestamp createDate;
}
