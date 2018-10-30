package kr.or.ddit.board.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;

@WebServlet(urlPatterns = { "/boardCre", "/boardUpdate" })
public class BoardCreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 요청 uri로 로직 분기
		String uri = request.getRequestURI();

		// 사용자 전체조회
		if (uri.equals("/boardCre")) {
			boardCre(request, response);
		}else if(uri.equals("/boardUpdate")){
			boardUpdate(request,response);
		}

	}

	private void boardUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String brd_id = request.getParameter("brd_id");
		String brd_name = request.getParameter("brd_name");
		String opval = request.getParameter("opval");
		
		int brd_chk = 0;
		if (opval.equals("사용")) {
			brd_chk = 0;
		} else {
			brd_chk = 1;
		}
		
		BoardServiceInf brdService = new BoardService();
		BoardVO brdVo = new BoardVO();
		brdVo.setBrd_id(brd_id);
		brdVo.setBrd_name(brd_name);
		brdVo.setBrd_chk(brd_chk);
		
		brdService.updateBrd(brdVo);
		
		List<BoardVO> brdList = brdService.selectBoardList();

		HttpSession session = request.getSession();
		session.setAttribute("brdList", brdList);
		response.sendRedirect("/board/boardMain.jsp");
		
	}

	private void boardCre(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("utf-8");

		BoardServiceInf brdService = new BoardService();

		String creval = request.getParameter("creval");
		String boardCre = request.getParameter("boardCre");
		UserVO userVo = (UserVO) request.getSession().getAttribute("LoginUser");

		String brd_mem = userVo.getUserId();
		int brd_chk = 0;
		if (creval.equals("사용")) {
			brd_chk = 0;
		} else {
			brd_chk = 1;
		}

		String brd_name = null;
		if (boardCre == null) {
			brd_name = "이름없음";
		} else {
			brd_name = boardCre;
		}

		BoardVO brdVo = new BoardVO();
		brdVo.setBrd_name(brd_name);
		brdVo.setBrd_chk(brd_chk);
		brdVo.setBrd_mem(brd_mem);

		int chk = brdService.insertBrd(brdVo);
		
		List<BoardVO> brdList = brdService.selectBoardList();

		HttpSession session = request.getSession();
		session.setAttribute("brdList", brdList);

		response.sendRedirect("/board/boardMain.jsp");

	}

}
