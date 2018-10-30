package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;


@WebServlet("/boardLogin")
public class BoardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String userId = request.getParameter("userId");
				String password = request.getParameter("password");
				
				UserServiceInf userService = new UserService();
				BoardServiceInf brdService = new BoardService();
				
				UserVO user = userService.selectUser(userId);
				
				List<BoardVO> brdList = brdService.selectBoardList();
				
				String chk = request.getParameter("remember-me");
				
				//chk == null : 아이디 기억 사용안함
				if(chk == null){
					Cookie[] cookies = request.getCookies();
					for(Cookie cookie: cookies){
						//cookie 이름이 remember,userId 일경우 maxage -1 설정하여 쿠키를 유효하지 않도록 설정
						if(cookie.getName().equals("userId")||cookie.getName().equals("remember")){
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
				//chk != null : 아이디 기억 사용
				else{
					Cookie cookie = new Cookie("remember", "Y");
					Cookie userIdCookie = new Cookie("userId", userId);
					
					response.addCookie(cookie);
					response.addCookie(userIdCookie);
				}

				if(user != null && user.getPass().equals(password)){

					HttpSession session = request.getSession();
					session.setAttribute("LoginUser", user);
					session.setAttribute("brdList", brdList);
					
					//dispatch
					RequestDispatcher rd = request.getRequestDispatcher("/board/boardMain.jsp");
					rd.forward(request,response);
				}	
				else{
					response.sendRedirect("/login/boardLogin.jsp");
				}
	}

}
