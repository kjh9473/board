package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;

@WebServlet("/comCre")
public class ComCreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String com_text= request.getParameter("ripple");
		String com_bul = request.getParameter("bul_id");
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("LoginUser");
		
		String com_mem = userVo.getUserId();
		
		BoardServiceInf brdService = new BoardService();
		
		CommentsVO comVo = new CommentsVO();
		comVo.setCom_bul(com_bul);
		comVo.setCom_text(com_text);
		comVo.setCom_mem(com_mem);
		
		brdService.comInsert(comVo);
		
		response.sendRedirect("/brdDetail?bulId="+com_bul);
	}

}
