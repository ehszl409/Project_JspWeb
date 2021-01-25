package com.park.reservation.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.park.reservation.config.DB;
import com.park.reservation.domain.user.dto.JoinReqDto;
import com.park.reservation.domain.user.dto.LoginReqDto;


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

}
