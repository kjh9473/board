package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;

@WebServlet("/bulReply")
public class BulReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bul_brd = request.getParameter("bul_brd");
		String bul_pid = request.getParameter("bul_id");
		
		BulletinVO bulVo = new BulletinVO();
		bulVo.setBul_id(bul_pid);
		bulVo.setBul_brd(bul_brd);
		
		request.setAttribute("bulVo",bulVo);
		
		request.getRequestDispatcher("/board/bulReply.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardServiceInf brdService = new BoardService();
		
		String bul_title = request.getParameter("bul_title");
		String bul_text = request.getParameter("smarteditor");
		String bul_pid = request.getParameter("bul_pid");
		String bul_brd = request.getParameter("bul_brd");
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("LoginUser");
		String bul_mem = userVo.getUserId();
		
		BulletinVO bulVo = new BulletinVO();
		bulVo.setBul_title(bul_title);
		bulVo.setBul_text(bul_text);
		bulVo.setBul_brd(bul_brd);
		bulVo.setBul_mem(bul_mem);
		bulVo.setBul_pid(bul_pid);
		
		brdService.bulReply(bulVo);
		
		response.sendRedirect("/freboardList?page=1&pageSize=10&brd_id="+bul_brd);
	}

}
