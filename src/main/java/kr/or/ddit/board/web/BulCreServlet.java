package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize = 1024*1024*5*5)
@WebServlet("/bulCre")
public class BulCreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/bulCre.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		BoardServiceInf brdService = new BoardService();
		
		
		Part profilePart = request.getPart("profile");
		Part profilePart1 = request.getPart("profile1");
		Part profilePart2 = request.getPart("profile2");
		Part profilePart3 = request.getPart("profile3");
		Part profilePart4 = request.getPart("profile4");
		
		String att_file = "";
		
		String bul_title = request.getParameter("bul_title");
		String bul_text = request.getParameter("smarteditor");
		String bul_brd = request.getParameter("bul_brd");
		
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("LoginUser");
		String bul_mem = userVo.getUserId();
		
		BulletinVO bulVo = new BulletinVO();
		bulVo.setBul_title(bul_title);
		bulVo.setBul_text(bul_text);
		bulVo.setBul_brd(bul_brd);
		bulVo.setBul_mem(bul_mem);
		
		
		brdService.insertBul(bulVo);
		
		String contentDisposition = 
				profilePart.getHeader("Content-disposition");
		String path = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\";
		att_file = StringUtil.getFileNameFromHeader(contentDisposition);
		
		if(!(att_file.equals(""))){
			profilePart.write(path + att_file);
			String path2 = path + att_file;
			profilePart.delete();
			
			AttachedVO attVo = new AttachedVO();
			attVo.setAtt_file(att_file);
			attVo.setAtt_path(path2);
			
			brdService.fileInsert(attVo);
		} 
		
		if(profilePart1 != null){
			 contentDisposition = 
					profilePart1.getHeader("Content-disposition");
			att_file = StringUtil.getFileNameFromHeader(contentDisposition);
			
			profilePart1.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file);
			String path2 = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file;
			profilePart1.delete();
			
			AttachedVO attVo = new AttachedVO();
			attVo.setAtt_file(att_file);
			attVo.setAtt_path(path2);
			
			brdService.fileInsert(attVo);
		} 
		
		if(profilePart2 != null){
			 contentDisposition = 
					profilePart2.getHeader("Content-disposition");
			
			att_file = StringUtil.getFileNameFromHeader(contentDisposition);
			
			profilePart2.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file);
			String path2 = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file;
			profilePart2.delete();
			
			AttachedVO attVo = new AttachedVO();
			attVo.setAtt_file(att_file);
			attVo.setAtt_path(path2);
			
			brdService.fileInsert(attVo);
		} 
		if(profilePart3 != null){
			 contentDisposition = 
					profilePart3.getHeader("Content-disposition");
			
			att_file = StringUtil.getFileNameFromHeader(contentDisposition);
			
			profilePart3.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file);
			String path2 = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file;
			profilePart3.delete();
			
			AttachedVO attVo = new AttachedVO();
			attVo.setAtt_file(att_file);
			attVo.setAtt_path(path2);
			
			brdService.fileInsert(attVo);
			
		} 
		if(profilePart4 != null){
			 contentDisposition = 
					profilePart4.getHeader("Content-disposition");
			att_file = StringUtil.getFileNameFromHeader(contentDisposition);
			
			profilePart4.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file);
			String path2 = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + att_file;
			profilePart4.delete();
			
			AttachedVO attVo = new AttachedVO();
			attVo.setAtt_file(att_file);
			attVo.setAtt_path(path2);
			
			brdService.fileInsert(attVo);
			
		}
		
		response.sendRedirect("/freboardList?page=1&pageSize=10&brd_id="+bul_brd);

	}

}
