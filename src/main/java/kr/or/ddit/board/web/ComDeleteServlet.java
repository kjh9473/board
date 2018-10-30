package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/comDelete")
public class ComDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String com_id = request.getParameter("comid");
		String com_bul = request.getParameter("com_bul");
		System.out.println(com_id + "adksjfi");
		System.out.println("com_bul" + com_bul);
		
		BoardServiceInf brdService = new BoardService();
		
		brdService.comDelete(com_id);
		
		response.sendRedirect("/brdDetail?bulId="+com_bul);
		
	}

}
