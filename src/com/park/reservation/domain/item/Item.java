package com.park.reservation.domain.item;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Item {
	private int id;
	private int imageId;
	private String itemname;
	private int price;
	private String content;
	private String subcontent;
	private String make;
	private String sellByDate;
	private String calorie;
	private String material;
	private Timestamp createDate;
}
