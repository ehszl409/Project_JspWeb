package com.park.reservation.service;

import java.util.List;

import com.park.reservation.domain.item.Item;
import com.park.reservation.domain.item.ItemBoard;
import com.park.reservation.domain.item.ItemDao;
import com.park.reservation.domain.item.dto.DetailReqDto;
import com.park.reservation.domain.item.dto.ListReqDto;

public class ItemService {
	
	ItemDao itemDao;
	
	public ItemService() {
		itemDao = new ItemDao();
	}
	
	public List<ListReqDto> 목록보기(int page){
		return itemDao.findAll(page);
	}
	
	public List<ListReqDto> 목록보기(){
		return itemDao.findAll();
	}
	
	public int 글개수() {
		return itemDao.count();
	}
	
	public DetailReqDto 글상세보기(int id) {
		return itemDao.findById(id);
	}
}
