package com.park.reservation.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.park.reservation.domain.CommonRespDto;
import com.park.reservation.domain.cart.dto.CartReqDto;
import com.park.reservation.domain.cart.dto.addReqDto;
import com.park.reservation.service.CartService;
import com.park.reservation.utill.Script;

import javafx.scene.control.Alert;


@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		CartService cartService = new CartService();
		
		if(cmd.equals("add")) {
			System.out.println("add에 접근 함.");
			BufferedReader br = request.getReader();
			String readData = br.readLine();
			Gson gson = new Gson();
			addReqDto dto = gson.fromJson(readData, addReqDto.class);
			System.out.println("dto: " + dto);
			
			int result = cartService.장바구니추가(dto);
			
			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			if(result == 1) {
				commonRespDto.setStatusCode(1);
			} else if (result == 0) {
				commonRespDto.setStatusCode(0);
			} else {
				commonRespDto.setStatusCode(-1);				
			}
			
			
			String respData = gson.toJson(commonRespDto);
			Script.responseData(response, respData);
		} else if(cmd.equals("list")) {
			System.out.println("list에 접근 함.");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			List<CartReqDto> dto = cartService.주문목록(id);
			int totalPrice = cartService.총금액(id);
			System.out.println(dto);
			if(dto != null) {
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("cart.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "주문목록을 가져오는데 실패했습니다.");
			}
			
			
		} else if(cmd.equals("delete")) {
			System.out.println("delete에 접근 함.");
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int userId = Integer.parseInt(request.getParameter("userId"));
			
			System.out.println("itemId: " + itemId);
			System.out.println("userId: " + userId);
			
			int result = cartService.삭제(itemId, userId);
			CommonRespDto<String> commonRespDto = new CommonRespDto<>();
			if(result != -1) {
				commonRespDto.setStatusCode(1);
			} else {
				commonRespDto.setStatusCode(-1);
			}
			Gson gson = new Gson();
			String respData = gson.toJson(commonRespDto);
			Script.responseData(response, respData);			
		}
		
		
		
		
		
		
		
	}

}
