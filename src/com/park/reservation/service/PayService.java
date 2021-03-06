package com.park.reservation.service;

import com.park.reservation.domain.pay.Pay;
import com.park.reservation.domain.pay.PayDao;
import com.park.reservation.domain.pay.dto.AddReqDto;
import com.park.reservation.domain.pay.dto.InfoReqDto;
import com.park.reservation.domain.pay.dto.PayDetailReqDto;

public class PayService {
	
	private PayDao payDao;
	
	public PayService() {
		payDao = new PayDao();
	}
	
	public int 결제추가(AddReqDto dto) {
		return payDao.save(dto);
	}
	
	public PayDetailReqDto 결제정보(int id, String mId) {
		return payDao.findByUserIdAndMId(id, mId);
	}
	
	public int 주문아이템(int id, int payId) {
		return payDao.saveItem(id, payId);
	}
}
