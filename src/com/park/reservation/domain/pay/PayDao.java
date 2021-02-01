package com.park.reservation.domain.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.park.reservation.config.DB;
import com.park.reservation.domain.cart.dto.addReqDto;
import com.park.reservation.domain.pay.dto.AddReqDto;
import com.park.reservation.domain.pay.dto.InfoReqDto;
import com.park.reservation.domain.pay.dto.PayDetailReqDto;


public class PayDao {
	
	
	public int saveItem(int id, int payId) {
		String sql = "insert into payItem(itemId, userId, payId, createDate) select o.itemId, o.userId, p.id, now() from orderInfo as o, pay as p where o.userId = ? and p.id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, payId);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int save(AddReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO pay (userId, storeId, payName, payAmount, buyer_email, buyer_name, buyer_tel, buyer_addr, pay_method, merchant_uid, pg_tid, imp_uid, paid_at, pickup, message, createDate) ");
		sb.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setInt(2, dto.getStoreId());
			pstmt.setString(3, dto.getPayName());
			pstmt.setString(4, dto.getPayAmount());
			pstmt.setString(5, dto.getBuyer_email());
			pstmt.setString(6, dto.getBuyer_name());
			pstmt.setString(7, dto.getBuyer_tel());
			pstmt.setString(8, dto.getBuyer_addr());
			pstmt.setString(9, dto.getPay_method());
			pstmt.setString(10, dto.getMerchant_uid());
			pstmt.setString(11, dto.getPg_tid());
			pstmt.setString(12, dto.getImp_uid());
			pstmt.setString(13, dto.getPaid_at());
			pstmt.setString(14, dto.getPickup());
			pstmt.setString(15, dto.getMessage());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
		
	public PayDetailReqDto findByUserIdAndMId(int id, String mId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select p.id, p.userId, p.storeId, p.payAmount, p.buyer_email, p.buyer_name, p.buyer_tel, ");
		sb.append("p.buyer_addr, p.pay_method, p.pickup, p.message, p.createDate, s.name, s.roadAddress, s.address, s.phone ");
		sb.append("FROM pay p inner join store s ");
		sb.append("on p.storeId = s.id ");
		sb.append("where p.userId= ? and p.merchant_uid = ?");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, mId);
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				PayDetailReqDto dto = new PayDetailReqDto();
				dto.setId(rs.getInt("p.id"));
				dto.setUserId(rs.getInt("p.userId"));
				dto.setStoreId(rs.getInt("p.storeId"));
				dto.setPayAmount(rs.getString("p.payAmount"));
				dto.setBuyer_email(rs.getString("p.buyer_email"));
				dto.setBuyer_name(rs.getString("p.buyer_name"));
				dto.setBuyer_tel(rs.getString("p.buyer_tel"));
				dto.setBuyer_addr(rs.getString("p.buyer_addr"));
				dto.setPay_method(rs.getString("p.pay_method"));
				dto.setPickup(rs.getString("p.pickup"));
				dto.setMessage(rs.getString("p.message"));
				dto.setName(rs.getString("s.name"));
				dto.setRoadAddress(rs.getString("s.roadAddress"));
				dto.setAddress(rs.getString("s.address"));
				dto.setPhone(rs.getString("s.phone"));
				dto.setCreateDate(rs.getTimestamp("p.createDate"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null; // 없어
	}

}
