package com.park.reservation.domain.user.dto;

import lombok.Data;

@Data
public class LoginReqDto {
	private String username;
	private String password;
}
