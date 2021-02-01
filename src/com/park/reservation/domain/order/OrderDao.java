package com.park.reservation.domain.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.park.reservation.config.DB;
import com.park.reservation.domain.order.dto.AddStoreReqDto;
import com.park.reservation.domain.order.dto.OrderReqDto;


public class OrderDao {
	
	public int totalPrice(int userId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(price) FROM ");
		sb.append("orderInfo o INNER JOIN item i ");
		sb.append("ON o.itemId = i.id ");
		sb.append("WHERE o.userId = ?");
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
	
	public List<OrderReqDto> findByUserId(int userId){
		StringBuffer sb = new StringBuffer();
		sb.append("select o.id, o.userId, o.itemId, z.itemname, z.price, z.make, z.calorie, z.sellByDate, z.material, z.image, o.createDate from ");
		sb.append("orderInfo o inner join ");
		sb.append("(select i.id, i.itemname, i.price, i.make, i.calorie, i.sellByDate, i.material, m.image from ");
		sb.append("item i inner join image m ");
		sb.append("on i.imageId = m.id) as z ");
		sb.append("on o.itemId = z.id ");
		sb.append("where o.userId = ?");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		List<OrderReqDto> dtos = new ArrayList<>();
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				OrderReqDto dto = new OrderReqDto();
				dto.setId(rs.getInt("o.id"));
				dto.setUserId(rs.getInt("o.userId"));
				dto.setItemId(rs.getInt("o.itemId"));
				dto.setItemname(rs.getString("z.itemname"));
				dto.setPrice(rs.getInt("z.price"));
				dto.setMake(rs.getString("z.make"));
				dto.setCalorie(rs.getString("z.calorie"));
				dto.setSellByDate(rs.getString("z.sellByDate"));
				dto.setMaterial(rs.getString("z.material"));
				dto.setImage(rs.getString("z.image"));
				dto.setCreateDate(rs.getTimestamp("o.createDate"));
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
	
	public int deleteAll(int id) {
		String sql = "DELETE FROM orderInfo WHERE userId = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int save(int id) {
		String sql = "INSERT INTO orderInfo(userId, itemId, createDate) select userId, itemId, now() from cart WHERE userId = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}
	
	public int saveStore(AddStoreReqDto dto) {
		String sql = "INSERT INTO store(userId, name, roadAddress, address, phone, createDate) VALUES(?,?,?,?,?,now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int generateKey;
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getRoadAddress());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getPhone());
			int result = pstmt.executeUpdate();
			
			// storeId를 리턴 해주기 위한 방법.
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				generateKey = rs.getInt(1);
				System.out.println("생성된 ID키:" + generateKey);
				if(result == 1) {
					return generateKey;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}

	public Store findById(int id) {
		String sql = "SELECT id, userId, name, roadAddress, address, phone, createDate FROM store WHERE id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setUserId(rs.getInt("userId"));
				store.setName(rs.getString("name"));
				store.setRoadAddress(rs.getString("roadAddress"));
				store.setAddress(rs.getString("address"));
				store.setPhone(rs.getString("phone"));
				store.setCreateDate(rs.getTimestamp("createDate"));
				return store;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return null;
	}

}
