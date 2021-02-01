package com.park.reservation.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.park.reservation.domain.CommonRespDto;
import com.park.reservation.domain.order.Store;
import com.park.reservation.domain.order.dto.AddStoreReqDto;
import com.park.reservation.domain.order.dto.OrderReqDto;

import com.park.reservation.service.OrderService;
import com.park.reservation.utill.Script;


@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderController() {
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
		OrderService orderService = new OrderService();
		
		
		if(cmd.equals("orderForm")) {
			System.out.println("orderForm접근 함.");
			int id = Integer.parseInt(request.getParameter("id"));
			
			List<OrderReqDto> dto = orderService.주문목록(id);
			int totalPrice = orderService.총금액(id);
			System.out.println(dto);
			if(dto != null) {
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("dto", dto);
				RequestDispatcher dis = request.getRequestDispatcher("order/orderForm.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "주문목록을 가져오는데 실패했습니다.");
			}
			
		} else if(cmd.equals("addOrder")) {
			System.out.println("addOrder에 접근 함.");
			int id = Integer.parseInt(request.getParameter("id"));
			
			int result = orderService.주문추가(id);
			
			if(result != -1) {
				RequestDispatcher dis = request.getRequestDispatcher("order?cmd=orderForm&id="+ id);
				dis.forward(request, response);
			} else {
				Script.back(response, "결제창을 불러오는데 실패했습니다.");
			}
		} else if(cmd.equals("addStore")) {
			System.out.println("addStore접근 확인 됨.");
			BufferedReader br = request.getReader();
			String readData = br.readLine();
			System.out.println("readData: " + readData);
			
			Gson gson = new Gson();
			AddStoreReqDto dto = gson.fromJson(readData, AddStoreReqDto.class);
			CommonRespDto<Store> commonRespDto = new CommonRespDto<>();
			
			int result = orderService.매장추가(dto);
			if(result != -1) {
				Store store = orderService.매장찾기(result);
				commonRespDto.setStatusCode(1);
				commonRespDto.setData(store);
			} else {
				commonRespDto.setStatusCode(-1);
			}
			
			String respData = gson.toJson(commonRespDto);
			Script.responseData(response, respData);
			
		} else if(cmd.equals("storeDetail")) {
			System.out.println("storeDetail에 접근 함.");
			int id = Integer.parseInt(request.getParameter("id"));
			
			Store store = orderService.매장찾기(id);
			
			if(store != null) {
				request.setAttribute("store", store);
				RequestDispatcher dis = request.getRequestDispatcher("order/orderForm.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "매장 정보를 가져오는데 실패 했습니다.");
			}
		}
		
	}

}
