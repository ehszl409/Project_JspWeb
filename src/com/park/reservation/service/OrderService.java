package com.park.reservation.service;

import java.util.List;

import com.park.reservation.domain.order.OrderDao;
import com.park.reservation.domain.order.Store;
import com.park.reservation.domain.order.dto.AddStoreReqDto;
import com.park.reservation.domain.order.dto.OrderReqDto;

public class OrderService {
	
	private OrderDao orderDao;
	
	public OrderService() {
		orderDao = new OrderDao();
	}
	
	public int 주문추가(int id) {
		int result = orderDao.deleteAll(id);
		if (result != -1) {
			return orderDao.save(id);			
		} else {
			return -1;
		}
	}
	
	public int 매장추가(AddStoreReqDto dto) {
		return orderDao.saveStore(dto);
	}
	
	public Store 매장찾기(int id) {
		return orderDao.findById(id);
	}
	
	public List<OrderReqDto> 주문목록(int id){
		return orderDao.findByUserId(id);
	}
	
	public int 총금액(int id) {
		return orderDao.totalPrice(id);
	}
}
