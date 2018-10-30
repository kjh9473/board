package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/bulDelete")
public class BulDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bul_id = request.getParameter("bul_id");

		BoardServiceInf brdService = new BoardService();
		
		brdService.bulDelete(bul_id);
		
		BulletinVO bulVo = brdService.searchBul(bul_id);
		
		response.sendRedirect("/freboardList?page=1&pageSize=10&brd_id="+bulVo.getBul_brd());
		
	}

}
