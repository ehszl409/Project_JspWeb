package com.park.reservation.domain.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.park.reservation.config.DB;
import com.park.reservation.domain.cart.dto.addReqDto;
import com.park.reservation.domain.pay.dto.AddReqDto;
import com.park.reservation.domain.pay.dto.InfoReqDto;


public class PayDao {
	
	public int save(AddReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO pay (userId, payName, payAmount, buyer_email, buyer_name, buyer_tel, buyer_addr, pay_method, merchant_uid, pg_tid, imp_uid, paid_at, pickup, message, createDate) ");
		sb.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getPayName());
			pstmt.setString(3, dto.getPayAmount());
			pstmt.setString(4, dto.getBuyer_email());
			pstmt.setString(5, dto.getBuyer_name());
			pstmt.setString(6, dto.getBuyer_tel());
			pstmt.setString(7, dto.getBuyer_addr());
			pstmt.setString(8, dto.getPay_method());
			pstmt.setString(9, dto.getMerchant_uid());
			pstmt.setString(10, dto.getPg_tid());
			pstmt.setString(11, dto.getImp_uid());
			pstmt.setString(12, dto.getPaid_at());
			pstmt.setString(13, dto.getPickup());
			pstmt.setString(14, dto.getMessage());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
		
	public InfoReqDto findByUserIdAndMId(int id, String mId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, userId, payName, payAmount, buyer_email, buyer_name, ");
		sb.append("buyer_tel, buyer_addr, pay_method, merchant_uid, pg_tid, imp_uid, paid_at, pickup, message, createDate ");
		sb.append("FROM pay WHERE userId = ? And merchant_uid = ?");
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
				InfoReqDto dto = new InfoReqDto();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getInt("userId"));
				dto.setPayName(rs.getString("payName"));
				dto.setPayAmount(rs.getString("payAmount"));
				dto.setBuyer_email(rs.getString("buyer_email"));
				dto.setBuyer_name(rs.getString("buyer_name"));
				dto.setBuyer_tel(rs.getString("buyer_tel"));
				dto.setBuyer_addr(rs.getString("buyer_addr"));
				dto.setPay_method(rs.getString("pay_method"));
				dto.setMerchant_uid(rs.getString("merchant_uid"));
				dto.setPg_tid(rs.getString("pg_tid"));
				dto.setImp_uid(rs.getString("imp_uid"));
				dto.setPaid_at(rs.getString("paid_at"));
				dto.setPickup(rs.getString("pickup"));
				dto.setMessage(rs.getString("message"));
				dto.setCreateDate(rs.getTimestamp("createDate"));
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
