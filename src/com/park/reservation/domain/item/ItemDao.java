package com.park.reservation.domain.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.park.reservation.config.DB;
import com.park.reservation.domain.item.dto.DetailReqDto;
import com.park.reservation.domain.item.dto.ListReqDto;

public class ItemDao {
	
	public List<ListReqDto> findAll() { // 게시물 목록
		StringBuffer sb = new StringBuffer();
		sb.append("select i.id, i.itemname, i.price, i.subcontent, m.image from ");
		sb.append("item i inner join image m ");
		sb.append("on i.imageId = m.id ");
		sb.append("order by i.id asc limit 0,4");
		
		// DB 연결	
		Connection conn = DB.getConnection();
		// 쿼리를 파싱해준다.
		PreparedStatement pstmt = null;
		// 게시글들을 담을 리스트 객체 생성.
		List<ListReqDto> dto = new ArrayList<>();
		
		ResultSet rs = null;
		try {
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ListReqDto itemBoards = new ListReqDto();
				itemBoards.setId(rs.getInt("i.id"));
				itemBoards.setItemname(rs.getString("i.itemname"));
				itemBoards.setImage(rs.getString("m.image"));
				itemBoards.setSubcontent(rs.getString("i.subcontent"));
				itemBoards.setPrice(rs.getInt("i.price"));
				dto.add(itemBoards);
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pstmt, rs);
		}
		return null;
	
	} // 게시물 목록
		
	// DAO의 역할 DB에 접근에 쿼리를 실행해서 데이터를 리턴해줘야 한다
		public List<ListReqDto> findAll(int page) { // 게시물 목록
			StringBuffer sb = new StringBuffer();
			sb.append("select i.id, i.itemname, i.price, i.subcontent, m.image from ");
			sb.append("item i inner join image m ");
			sb.append("on i.imageId = m.id ");
			sb.append("order by i.id desc limit ?,8");
			
			// DB 연결	
			Connection conn = DB.getConnection();
			// 쿼리를 파싱해준다.
			PreparedStatement pstmt = null;
			// 게시글들을 담을 리스트 객체 생성.
			List<ListReqDto> dto = new ArrayList<>();
			
			ResultSet rs = null;
			try {
				String sql = sb.toString();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, page*8);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ListReqDto itemBoards = new ListReqDto();
					itemBoards.setId(rs.getInt("i.id"));
					itemBoards.setItemname(rs.getString("i.itemname"));
					itemBoards.setImage(rs.getString("m.image"));
					itemBoards.setSubcontent(rs.getString("i.subcontent"));
					itemBoards.setPrice(rs.getInt("i.price"));
					dto.add(itemBoards);
				}
				return dto;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DB.close(conn, pstmt, rs);
			}
			return null;
		
		} // 게시물 목록
		
		public int count() { // 총 게시글 찾기
			// 쿼리 준비
			String sql = "SELECT count(*) FROM item";
			Connection conn = DB.getConnection();
			// 쿼리를 파싱해준다.
			PreparedStatement pstmt = null;
			
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();		
				if(rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DB.close(conn, pstmt, rs);
			}
			return -1;
		} // 총 게시글 찾기
		
		public DetailReqDto findById(int id) { // 게시글 상세보기
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT i.id, i.itemname, i.price, i.content, i.make, i.sellByDate, i.calorie, i.material, m.image from ");
			sb.append("item i inner join image m ");
			sb.append("on i.imageId = m.id ");
			sb.append("where i.id = ?");
			Connection conn = DB.getConnection();
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				String sql = sb.toString();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();		
				if(rs.next()) {
					DetailReqDto dto = new DetailReqDto();
					dto.setId(rs.getInt("i.id"));
					dto.setImage(rs.getString("m.image"));
					dto.setItemname(rs.getString("i.itemname"));
					dto.setContent(rs.getString("i.content"));
					dto.setPrice(rs.getInt("i.price"));
					dto.setCalorie(rs.getString("i.calorie"));
					dto.setMake(rs.getString("i.make"));
					dto.setSellByDate(rs.getString("i.sellByDate"));
					dto.setMaterial(rs.getString("i.material"));
					return dto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DB.close(conn, pstmt, rs);
			}
			return null;
		} // 게시글 상세 보기
}
