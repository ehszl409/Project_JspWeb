package com.park.reservation.domain.item.dto;

import lombok.Data;

@Data
public class DetailReqDto {
	private int id;
	private int price;
	private String itemname;
	private String content;
	private String image;
	private String make;
	private String sellByDate;
	private String calorie;
	private String material;
	
}
