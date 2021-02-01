package com.park.reservation.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.park.reservation.config.DB;
import com.park.reservation.domain.pay.dto.PayDetailReqDto;
import com.park.reservation.domain.user.dto.JoinReqDto;
import com.park.reservation.domain.user.dto.LoginReqDto;
import com.park.reservation.domain.user.dto.MyPageReqDto;


public class UserDao {
	
	public User findByUsernameAndPassword(LoginReqDto dto) { 
		String sql = "SELECT id, username, email, address FROM user WHERE username = ? AND password = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			// dto에 담겨 있는 username과 password를 쿼리문에 넣어준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			rs =  pstmt.executeQuery();

			// 여기서 username과 password가 있는지 살펴보는데,
			// 테이블의 스키마를 한 줄 내려가면서 살펴본다.
			// username과 password를 담은 쿼리문이 존재 한다는 것은 
			// 가입되어 있는 사용자 라는 뜻이기에 해당 row에 있는 id,username, email, address를
			// user 오브젝트에 담아서 리턴 해준다.
			if(rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.address(rs.getString("address"))
						.build();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public User findByUserId(LoginReqDto dto) { 
		String sql = "SELECT id, username, email, address FROM user WHERE username = ? AND password = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			// dto에 담겨 있는 username과 password를 쿼리문에 넣어준다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			rs =  pstmt.executeQuery();

			// 여기서 username과 password가 있는지 살펴보는데,
			// 테이블의 스키마를 한 줄 내려가면서 살펴본다.
			// username과 password를 담은 쿼리문이 존재 한다는 것은 
			// 가입되어 있는 사용자 라는 뜻이기에 해당 row에 있는 id,username, email, address를
			// user 오브젝트에 담아서 리턴 해준다.
			if(rs.next()) {
				User user = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.address(rs.getString("address"))
						.build();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int join(JoinReqDto dto) { // 회원가입
		String sql = "INSERT INTO user(username, password, email, address, createDate) VALUES(?,?,?,?, now())";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddress());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt);
		}
		return -1;
	}// 회원가입
	
	public int findByUsername(String username) {//아이디 중복 체크
		String sql = "SELECT * FROM user WHERE username = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
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
	}//아이디 중복 체크
	
	public User findById(int id) {//아이디 중복 체크
		String sql = "SELECT id, username, password, email, address, createDate FROM user WHERE id = ?";
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs =  pstmt.executeQuery();

			if(rs.next()) {
				User user = new User().builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.password(rs.getString("password"))
						.email(rs.getString("email"))
						.address(rs.getString("address"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null; // 없어
	}//아이디 중복 체크
	
	public List<MyPageReqDto> findByUserId(int id) {//아이디 중복 체크
		StringBuffer sb = new StringBuffer();
		sb.append("select p.id, p.userId, p.storeId, p.payAmount, p.buyer_email, p.buyer_name, p.buyer_tel, ");
		sb.append("p.buyer_addr, p.pay_method, p.pickup, p.message, p.createDate, ");
		sb.append("s.name, s.roadAddress, s.address, s.phone ");
		sb.append("from pay p ");
		sb.append("inner join user u on p.userId = u.id ");
		sb.append("inner join store s on p.userId = s.id ");
		sb.append("where p.userid = ? ");
		Connection conn = DB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		List<MyPageReqDto> dtos = new ArrayList<>();
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs =  pstmt.executeQuery();

			while(rs.next()) {
				MyPageReqDto dto = new MyPageReqDto();
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
				dto.setPayCreateDate(rs.getTimestamp("p.createDate"));
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 무조건 실행
			DB.close(conn, pstmt, rs);
		}
		return null;
	}//아이디 중복 체크
	
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
