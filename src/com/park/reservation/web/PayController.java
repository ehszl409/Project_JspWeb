package com.park.reservation.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.park.reservation.domain.CommonRespDto;
import com.park.reservation.domain.cart.dto.addReqDto;
import com.park.reservation.domain.pay.dto.AddReqDto;
import com.park.reservation.domain.pay.dto.InfoReqDto;
import com.park.reservation.service.PayService;
import com.park.reservation.utill.Script;

@WebServlet("/pay")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PayController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		PayService payService = new PayService();

		if (cmd.equals("add")) {
			System.out.println("add접근 확인 됨.");
			BufferedReader br = request.getReader();
			String readData = br.readLine();
			System.out.println("readData: " + readData);

			Gson gson = new Gson();
			AddReqDto dto = gson.fromJson(readData, AddReqDto.class);
			CommonRespDto<AddReqDto> commonRespDto = new CommonRespDto<>();

			int result = payService.결제추가(dto);
			if (result != -1) {
				commonRespDto.setStatusCode(1);

			} else {
				commonRespDto.setStatusCode(-1);
			}
			String respData = gson.toJson(commonRespDto);
			Script.responseData(response, respData);

		} else if (cmd.equals("paySuccess")) {
			System.out.println("paySuccess에 접근 함.");
			int id = Integer.parseInt(request.getParameter("id"));
			String mId = request.getParameter("mId");
			System.out.println("id: " + id);
			System.out.println("mId: " + mId);

			InfoReqDto dto = payService.결제정보(id, mId);
			request.setAttribute("payInfo", dto);
			RequestDispatcher dis = request.getRequestDispatcher("paySuccessPage.jsp");
			dis.forward(request, response);

		}

	}

}
