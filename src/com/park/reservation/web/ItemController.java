package com.park.reservation.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.reservation.domain.item.Item;
import com.park.reservation.domain.item.ItemBoard;
import com.park.reservation.domain.item.dto.DetailReqDto;
import com.park.reservation.domain.item.dto.ListReqDto;
import com.park.reservation.service.ItemService;
import com.park.reservation.utill.Script;


@WebServlet("/item")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ItemController() {
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
		ItemService itemService = new ItemService();
		
		if(cmd.equals("list")) {
			System.out.println("list접근 확인.");
			int page = Integer.parseInt(request.getParameter("page"));
			List<ListReqDto> dto = itemService.목록보기(page);
			System.out.println("itemBoards:" + dto);
			
			int itemBoardCount = itemService.글개수();
			int lastPage = (itemBoardCount-1)/8;
			
			
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("itemDto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
		} else if(cmd.equals("detail")) {
			System.out.println("detail접근 확인.");
			int id = Integer.parseInt(request.getParameter("id"));
			DetailReqDto dto = itemService.글상세보기(id);
			List<ListReqDto> listDto = itemService.목록보기();
			
			if(dto == null) {
				Script.back(response, "상세보기에 실패 했습니다.");
			} else {
				request.setAttribute("dto", dto);
				request.setAttribute("listDto", listDto);
				RequestDispatcher dis = request.getRequestDispatcher("detail.jsp");
				dis.forward(request, response);
			}
		}
		
		
	}
	
	

}
