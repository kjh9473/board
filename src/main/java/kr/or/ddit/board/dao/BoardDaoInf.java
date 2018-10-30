package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.model.CommentsVO;

public interface BoardDaoInf {
	/**
	* Method : bulList
	* 작성자 : pc25
	* 변경이력 :
	* @param bul_brd
	* @return
	* Method 설명 : 게시판ID를 받아 해당 게시판에 게시글을 List로 불러온다.
	*/
	public List<BulletinVO> selectBulletinList(Map<String, Object> map);
	
	/**
	* Method : selectBoardList
	* 작성자 : pc25
	* 변경이력 :
	* @param brd_mem
	* @return
	* Method 설명 :로그인한 아이디를 받아 생성한 게시판 리스트를 List로 반환
	*/
	public List<BoardVO> selectBoardList();
	
	
	/**
	* Method : BulletinCnt
	* 작성자 : pc25
	* 변경이력 :
	* @param bul_brd
	* @return
	* Method 설명 :리스트 사이즈 조회
	*/
	public int BulletinCnt(String bul_brd);
	
	/**
	* Method : insertBrd
	* 작성자 : pc25
	* 변경이력 :
	* @param brdVo
	* @return
	* Method 설명 : 게시판 생성
	*/
	public int insertBrd(BoardVO brdVo);
	
	/**
	* Method : updateBrd
	* 작성자 : pc25
	* 변경이력 :
	* @param brdVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	public int updateBrd(BoardVO brdVo);
	
	/**
	* Method : allBoardList
	* 작성자 : pc25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 리스트
	*/
	public List<BoardVO> allBoardList(String brd_mem);
	
	/**
	* Method : searchBul
	* 작성자 : pc25
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 상세조회
	*/
	public BulletinVO searchBul(String bul_id);
	
	/**
	* Method : insertBul
	* 작성자 : pc25
	* 변경이력 :
	* @param bulVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	public int insertBul(BulletinVO bulVo);
	
	/**
	* Method : bulUpdate
	* 작성자 : pc25
	* 변경이력 :
	* @param bulVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	public int bulUpdate(BulletinVO bulVo);
	
	/**
	* Method : bulDelete
	* 작성자 : pc25
	* 변경이력 :
	* @param bul_id
	* @return
	* Method 설명 : 게시글 삭제
	*/
	public int bulDelete(String bul_id);
	
	/**
	* Method : bulReply
	* 작성자 : pc25
	* 변경이력 :
	* @param bulVo
	* @return
	* Method 설명 : 게시글의 답글
	*/
	public int bulReply(BulletinVO bulVo);
	
	/**
	* Method : comInsert
	* 작성자 : pc25
	* 변경이력 :
	* @param comVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	public int comInsert(CommentsVO comVo);
	
	/**
	* Method : comSearch
	* 작성자 : pc25
	* 변경이력 :
	* @param com_bul
	* @return
	* Method 설명 : 해당 게시글 댓글 조회
	*/
	public List<CommentsVO> comSearch(String com_bul);
	
	/**
	* Method : comDelete
	* 작성자 : pc25
	* 변경이력 :
	* @param com_id
	* @return
	* Method 설명 : 댓글 삭제
	*/
	public int comDelete(String com_id);
	
	/**
	* Method : fileInsert
	* 작성자 : pc25
	* 변경이력 :
	* @param attVo
	* @return
	* Method 설명 : 게시글에 파일 등록
	*/
	public int fileInsert(AttachedVO attVo);
	
	/**
	* Method : attSearch
	* 작성자 : pc25
	* 변경이력 :
	* @param att_bul
	* @return
	* Method 설명 : 첨부파일 조회
	*/
	public List<AttachedVO> attSearch(String att_bul);
	
	
}
