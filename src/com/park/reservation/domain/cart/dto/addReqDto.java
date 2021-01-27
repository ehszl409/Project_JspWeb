package com.park.reservation.domain.cart.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class addReqDto {
	private int userId;
	private int itemId;
}
