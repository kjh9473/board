package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.BulletinVO;

import org.junit.Before;
import org.junit.Test;

public class BoardDaoTest {
	
	private BoardDaoInf dao;
	
	@Before
	public void setup(){
		dao = new BoardDao();
	}
	
	@Test
	public void selectBulletinListTest() {
		/***Given***/
		
		/***When***/
		String bul_brd = "BRD21";
		int page = 1;
		int pageSize = 10;
		
		Map<String,Object> brdMap = new HashMap<String, Object>();
		brdMap.put("bul_brd",bul_brd);
		brdMap.put("page",page);
		brdMap.put("pageSize",pageSize);
		
		List<BulletinVO> bulList = dao.selectBulletinList(brdMap);
		
		/***Then***/
		assertEquals(5,bulList.size());
	}
	
	@Test
	public void selectBoardListTest(){
		/***Given***/
		
		/***When***/
		String brd_mem = "brown";
		List<BoardVO> brdList = dao.selectBoardList();
		
		/***Then***/
		assertEquals(2,brdList.size());
	}
	
	@Test
	public void fileInsert(){
		/***Given***/
		
		/***When***/
		AttachedVO attVo = new AttachedVO();
		attVo.setAtt_file("모름");
		attVo.setAtt_path("모름");
		
		int result = dao.fileInsert(attVo);
		/***Then***/
		assertEquals(1, result);

	}
	
//	/**
//	* Method : fileInsert
//	* 작성자 : pc25
//	* 변경이력 :
//	* @param attVo
//	* @return
//	* Method 설명 : 게시글에 파일 등록
//	*/
//	public int fileInsert(AttachedVO attVo);
}
