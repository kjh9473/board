package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.util.StringUtil;


@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize = 1024*1024*5*5)
@WebServlet("/bulUpdate")
public class BulUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceInf brdService = new BoardService();
		
		
		String bul_id = request.getParameter("bul_id");
		List<AttachedVO> attList = brdService.attSearch(bul_id);
		BulletinVO bulVo = brdService.searchBul(bul_id);
		
		request.setAttribute("bulVo",bulVo);
		request.setAttribute("attList",attList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/bulUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String profile = "";
		if(request.getParameter("profile") == null){
//			UserVO userVo2 = userService.selectUser(userId);
//			 profile = userVo2.getProfile();
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
		
		String bul_id = request.getParameter("bul_id");
		String bul_title = request.getParameter("bul_title");
		String bul_text = request.getParameter("smarteditor");
		
		BoardServiceInf brdService = new BoardService();
		
		BulletinVO bulVo = new BulletinVO();
		
		bulVo.setBul_id(bul_id);
		bulVo.setBul_title(bul_title);
		bulVo.setBul_text(bul_text);
		
		brdService.bulUpdate(bulVo);
		
		response.sendRedirect("/brdDetail?bulId="+bul_id);
		
	}

}
