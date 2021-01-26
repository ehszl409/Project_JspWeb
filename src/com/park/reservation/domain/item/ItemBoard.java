package com.park.reservation.domain.item;

import java.sql.Timestamp;

import lombok.Data;


@Data
public class ItemBoard {
	private int id;
	private int itemId;
	private String title;
	private String subcontent;
	private int price;
	private String image;
	private Timestamp createDate;
}
