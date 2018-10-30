package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

@WebServlet(urlPatterns = { "/freboardList", "/creboardList","/brdDetail"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 요청 uri로 로직 분기
		String uri = request.getRequestURI();

		// 사용자 전체조회
		if (uri.equals("/freboardList")) {
			freboardList(request, response);
		} else if (uri.equals("/creboardList")) {
			creboardList(request, response);
		} else if(uri.equals("/brdDetail")){
			brdDetail(request,response);
		}
	}

	private void brdDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceInf boardService = new BoardService();
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("LoginUser");
		String userId = userVo.getUserId();
		
		String bul_id = request.getParameter("bulId");
		
		BulletinVO bulVo = boardService.searchBul(bul_id);
		List<CommentsVO> comList = boardService.comSearch(bul_id);
		List<AttachedVO> attList = boardService.attSearch(bul_id);
		
		request.setAttribute("bulVo",bulVo);
		request.setAttribute("comList",comList);
		request.setAttribute("userId",userId);
		request.setAttribute("attList",attList);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/board/brdDetail.jsp");
		rd.forward(request, response);
		
	}

	private void creboardList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardService = new BoardService();

		String brd_mem = request.getParameter("userId");

		List<BoardVO> brdList2 = boardService.allBoardList(brd_mem);
		
		request.setAttribute("userId", brd_mem);
		request.setAttribute("brdList2", brdList2);

		RequestDispatcher rd = request
				.getRequestDispatcher("/board/boardCre.jsp");
		rd.forward(request, response);
		
	

	}

	private void freboardList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BoardServiceInf boardService = new BoardService();
		String bul_brd = request.getParameter("brd_id");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		PageVO pageVo = new PageVO();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);

		Map<String, Object> brdMap = new HashMap<String, Object>();
		brdMap.put("bul_brd", bul_brd);
		brdMap.put("pageVo", pageVo);

		// 해당 게시판 게시글
		List<BulletinVO> bulList = boardService.selectBulletinList(brdMap);
		// 해당 게시판 길이

		int size = boardService.BulletinCnt(bul_brd);
		int bulSize = (int) Math.ceil((double) size / pageSize);
		
		request.setAttribute("bulList", bulList);
		request.setAttribute("bulSize", bulSize);
		request.setAttribute("bul_brd", bul_brd);

		RequestDispatcher rd = request
				.getRequestDispatcher("/board/freboardList.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String bul_id = request.getParameter("userId");
	}

}
