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
import javax.servlet.http.HttpSession;

import com.park.reservation.domain.user.User;
import com.park.reservation.domain.user.dto.JoinReqDto;
import com.park.reservation.domain.user.dto.LoginReqDto;
import com.park.reservation.domain.user.dto.MyPageReqDto;
import com.park.reservation.service.UserService;
import com.park.reservation.utill.Script;

import javafx.scene.control.Alert;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
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
		UserService userService = new UserService();

		if (cmd.equals("joinForm")) {
			System.out.println("joinForm에 접근함.");
			RequestDispatcher dis = request.getRequestDispatcher("user/joinForm.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("main")) {
			System.out.println("main에 접근함.");
			RequestDispatcher dis = request.getRequestDispatcher("main/main.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("join")) {
		
			System.out.println("join에 접근함");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");

			JoinReqDto dto = new JoinReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			dto.setEmail(email);
			dto.setAddress(address);
			System.out.println("회원가입 : " + dto);

			int result = userService.회원가입(dto);
			if (result == 1) {
				response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "회원가입 실패");
			}
		} else if (cmd.equals("usernameCheck")) {
			BufferedReader br = request.getReader();
			String username = br.readLine();
			System.out.println(username);
			int result = userService.유저네임중복체크(username);
			PrintWriter out = response.getWriter();
			if (result == 1) {
				out.print("ok");
			} else {
				out.print("fail");
			}
			out.flush();
		} else if (cmd.equals("loginForm")) {
			System.out.println("loginForm에 접근함.");
			RequestDispatcher dis = request.getRequestDispatcher("user/loginForm.jsp");
			dis.forward(request, response);
		} else if (cmd.equals("login")) {
			System.out.println("login에 접근함.");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			LoginReqDto dto = new LoginReqDto();
			dto.setUsername(username);
			dto.setPassword(password);

			User userEntity = userService.로그인(dto);

			if (userEntity != null) {
				HttpSession session = request.getSession();
				session.setAttribute("principal", userEntity);
				response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "로그인에 실패 했습니다.");
			}

		} else if (cmd.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else if (cmd.equals("myPage")) {
			System.out.println("myPage에 접근 함.");
			int id = Integer.parseInt(request.getParameter("id"));
			
			List<MyPageReqDto> dtos = userService.마이페이지(id);
			User user = userService.유저정보(id);
			if(dtos != null && user != null) {
				request.setAttribute("userInfo", user);
				request.setAttribute("MyPageInfo", dtos);
				RequestDispatcher dis = request.getRequestDispatcher("user/myPage.jsp");
				dis.forward(request, response);
			} else {
				Script.back(response, "마이페이지 불러오기에 실패 했습니다.");
			}
			
		} else if (cmd.equals("orderItem")) {
			System.out.println("orderItem에 접근 함.");
			
		}
	}

}
