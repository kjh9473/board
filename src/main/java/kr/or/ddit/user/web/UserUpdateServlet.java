package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize = 1024*1024*5*5)
@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceInf userService = new UserService();
		String userId = request.getParameter("userId");
		
		UserVO userVo = userService.selectUser(userId);
		
		request.setAttribute("userVo", userVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceInf userService = new UserService();
		//post 한글 파라미터 인코딩처리
		request.setCharacterEncoding("utf-8");
		String profile = "";
		String userId = request.getParameter("userId");
		if(request.getParameter("profile") == null){
			UserVO userVo2 = userService.selectUser(userId);
			 profile = userVo2.getProfile();
		}else{
			Part  profilePart = request.getPart("profile");
			
			String contentDisposition = profilePart.getHeader("Content-disposition");
			
			String fileName = StringUtil.getFileNameFromHeader(contentDisposition);
			
			//파일쓰기
			//url정보를 실제 파일경로로 변경
			String path = getServletContext().getRealPath("/profile");
			
			profilePart.write(path + File.separator + fileName);
			profilePart.delete(); //파일 업로드 과정에서 사용한 디스크 임시 영역을 정리
			
			 profile = "/profile/"+fileName;
		}
		
		
		// 파라미터 받아오기
		// userId, name, pass, addr1, addr2, birth, zipcd, email, tel
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth"); //type
		String zipcd = request.getParameter("zipcd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		
		//파라미터를 userVo
		UserVO userVo = new UserVO();
		userVo.setUserId(userId);
		userVo.setPass(pass);
		userVo.setName(name);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			userVo.setBirth(format.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userVo.setZipcd(zipcd);
		userVo.setEmail(email);
		userVo.setTel(tel);
		userVo.setProfile(profile);
		
		// 사용자 등록 서비스 호출(미구현)
		int result = userService.updateUser(userVo);
		
		// 사용자 리스트로 이동
		//(redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다)
		response.sendRedirect("/userPageList?page=1&pageSize=10");
		
	}

}
