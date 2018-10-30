package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns={"/userAllList","/userPageList","/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 uri로 로직 분기
		String uri = request.getRequestURI();
		//사용자 전체조회
		if(uri.equals("/userAllList")){
			userAllList(request, response);
		}
		//사용자 페이징 조회
		else if(uri.equals("/userPageList")){
			userPageList(request, response);
		}
		// 사용자 상세조회
		else if(uri.equals("/userDetail")){
			userDetail(request, response);
		}
		
	}

	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		UserServiceInf userService = new UserService();
		
		//사용자 아이디가 파라미터로 넘어옴.
		String userId = request.getParameter("userId");
		
		//사용자 아이디에 해당하는 사용자 정보 조회
		UserVO userVo = userService.selectUser(userId);
		
		//jsp로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("userVo", userVo);
		
		//사용자 상세 화면으로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);
	}

	/**
	* Method : userPageList
	* 작성자 : pc25
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 사용자 페이지 리스트 조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void userPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//userService 생성
		//userPageList 호출 : 메소드 인자 -pageVO : page, pageSize
		//request 객체에 저장
		//forward(userAllList.jsp -->userPageList.jsp)
		UserServiceInf userService = new UserService();
		
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PageVO pageVo = new PageVO();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		Map<String,Object> resultMap = userService.selectUserPageList(pageVo);
		
		// 페이지 리스트
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		// 페이지 건수
		
		int pageCnt = (int)resultMap.get("pageCnt");
		
		//request 객체에 저장
		request.setAttribute("userList", userList);
		request.setAttribute("pageCnt", pageCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPageList.jsp");
		rd.forward(request, response);
		
	}

	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// 전체 사용자 정보조회
		UserServiceInf userService = new UserService();
		List<UserVO> userList = userService.selectUserAll();

		// 조회된 사용자 정보를 userAllList.jsp 처리
		// userAllList.jsp에서 userList를 참조하려면??
		// attribute
		
		//session : 해당 사용자만 접근 가능(사용자 전용 공간)
		//			--> 자주 참조하는 데이터
		//			--> 너무 많은 데이터를 저장할경우 ??? OOM 유발 가능성
		//application : 모든 사용자가 접근 가능(서버당 하나만 생성) 
		//			--> 일반적으로  설정과 관련된 값을 저장
		//request : 해당 요청의 응답이 끝날때 까지
		
		//getServletContext().setAttribute("userList", userList);
		
		request.setAttribute("userList",userList);
		
		//화면으로 위임
		//1.dispatch : 보통/일반적으로 사용 (조회할 경우)
		//2.sendRedirect : 서버에 데이터가 변경되 었을때
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
