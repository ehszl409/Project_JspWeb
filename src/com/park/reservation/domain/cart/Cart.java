package com.park.reservation.domain.cart;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Cart {
	private int id;
	private int userId;
	private int itemId;
	private int totalPrice;
	private Timestamp createDate;
}
