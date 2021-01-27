package com.park.reservation.domain.cart.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CartReqDto {
	private int id;
	private int userId;
	private int itemId;
	private int price;
	private String itemname;
	private String image;
	private String make;
	private String sellByDate;
	private String calorie;
	private String material;
	private Timestamp createDate;
}
