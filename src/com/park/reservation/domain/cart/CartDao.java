package com.park.reservation.domain.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.park.reservation.config.DB;
import com.park.reservation.domain.cart.dto.CartReqDto;
import com.park.reservation.domain.cart.dto.addReqDto;
import com.park.reservation.domain.item.dto.DetailReqDto;

public class CartDao {
	
	public int deleteByitemIdAndUserId(int itemId, int userId) {
		String sql = "DELETE FROM cart WHERE itemId = ? AND userId = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, userId);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}

	public int save(addReqDto dto) {
		String sql = "INSERT INTO cart(itemId, userId, createDate) VALUES(?,?,now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getItemId());
			pstmt.setInt(2, dto.getUserId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int findByItemIdAndUserId(addReqDto dto) {
		String sql = "SELECT * FROM cart WHERE itemId = ? AND userId = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getItemId());
			pstmt.setInt(2, dto.getUserId());
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				return 1; // 있어
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return -1; // 없어
	}
	
	
	public List<CartReqDto> findByUserId(int userId){
		StringBuffer sb = new StringBuffer();
		sb.append("select c.id, c.userId, c.itemId, z.itemname, z.price, z.make, z.calorie, z.sellByDate, z.material, z.image, c.createDate from ");
		sb.append("cart c inner join ");
		sb.append("(select i.id, i.itemname, i.price, i.make, i.calorie, i.sellByDate, i.material, m.image from ");
		sb.append("item i inner join image m ");
		sb.append("on i.imageId = m.id) as z ");
		sb.append("on c.itemId = z.id ");
		sb.append("where c.userId = ?");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<CartReqDto> dtos = new ArrayList<>();
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				CartReqDto dto = new CartReqDto();
				dto.setId(rs.getInt("c.id"));
				dto.setUserId(rs.getInt("c.userId"));
				dto.setItemId(rs.getInt("c.itemId"));
				dto.setItemname(rs.getString("z.itemname"));
				dto.setPrice(rs.getInt("z.price"));
				dto.setMake(rs.getString("z.make"));
				dto.setCalorie(rs.getString("z.calorie"));
				dto.setSellByDate(rs.getString("z.sellByDate"));
				dto.setMaterial(rs.getString("z.material"));
				dto.setImage(rs.getString("z.image"));
				dto.setCreateDate(rs.getTimestamp("c.createDate"));
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
		
	}
	
	public int totalPrice(int userId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(price) FROM ");
		sb.append("cart c INNER JOIN item i ");
		sb.append("ON c.itemId = i.id ");
		sb.append("WHERE c.userId = ?");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();		
			if(rs.next()) {
				return rs.getInt("SUM(price)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return -1;
		
	}
}
