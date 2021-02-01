package com.park.reservation.domain.order.dto;

import lombok.Data;

@Data
public class AddStoreReqDto {
	private int userId;
	private String name;
	private String roadAddress;
	private String address;
	private String phone;
}
