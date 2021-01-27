package com.park.reservation.service;

import java.util.List;

import com.park.reservation.domain.cart.CartDao;
import com.park.reservation.domain.cart.dto.CartReqDto;
import com.park.reservation.domain.cart.dto.addReqDto;

public class CartService {

	CartDao cartDao;
	
	public CartService() {
		cartDao = new CartDao();
	}
	
	public int 장바구니추가(addReqDto dto) {
		int result = cartDao.findByItemIdAndUserId(dto);
		if(result == 1) {
			return 0;
		} else {			
			return cartDao.save(dto);
		}
	}
	
	public List<CartReqDto> 주문목록(int userId){
		return cartDao.findByUserId(userId);
	}
	
	public int 삭제(int itemId, int userId) {
		return cartDao.deleteByitemIdAndUserId(itemId, userId);
	}
	
	public int 총금액(int userId) {
		return cartDao.totalPrice(userId);
	}
	
}
