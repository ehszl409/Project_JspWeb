package com.park.reservation.domain.item.dto;

import lombok.Data;

@Data
public class ListReqDto {
	private int id;
	private int price;
	private String itemname;
	private String subcontent;
	private String image;
}
