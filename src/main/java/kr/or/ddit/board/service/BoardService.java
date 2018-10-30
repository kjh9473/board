package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.model.CommentsVO;

public class BoardService implements BoardServiceInf {
	
	BoardDaoInf dao = new BoardDao();
	
	@Override
	public List<BulletinVO> selectBulletinList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectBulletinList(map);
	}

	@Override
	public List<BoardVO> selectBoardList() {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
	}


	@Override
	public int BulletinCnt(String bul_brd) {
		// TODO Auto-generated method stub
		return dao.BulletinCnt(bul_brd);
	}

	@Override
	public int insertBrd(BoardVO brdVo) {
		// TODO Auto-generated method stub
		return dao.insertBrd(brdVo);
	}

	@Override
	public int updateBrd(BoardVO brdVo) {
		// TODO Auto-generated method stub
		return dao.updateBrd(brdVo);
	}

	@Override
	public List<BoardVO> allBoardList(String brd_mem) {
		// TODO Auto-generated method stub
		return dao.allBoardList(brd_mem);
	}

	@Override
	public BulletinVO searchBul(String bul_id) {
		// TODO Auto-generated method stub
		return dao.searchBul(bul_id);
	}

	@Override
	public int insertBul(BulletinVO bulVo) {
		// TODO Auto-generated method stub
		return dao.insertBul(bulVo);
	}

	@Override
	public int bulUpdate(BulletinVO bulVo) {
		// TODO Auto-generated method stub
		return dao.bulUpdate(bulVo);
	}

	@Override
	public int bulDelete(String bul_id) {
		// TODO Auto-generated method stub
		return dao.bulDelete(bul_id);
	}

	@Override
	public int bulReply(BulletinVO bulVo) {
		// TODO Auto-generated method stub
		return dao.bulReply(bulVo);
	}

	@Override
	public int comInsert(CommentsVO comVo) {
		// TODO Auto-generated method stub
		return dao.comInsert(comVo);
	}

	@Override
	public List<CommentsVO> comSearch(String com_bul) {
		// TODO Auto-generated method stub
		return dao.comSearch(com_bul);
	}

	@Override
	public int comDelete(String com_id) {
		// TODO Auto-generated method stub
		return dao.comDelete(com_id);
	}

	@Override
	public int fileInsert(AttachedVO attVo) {
		// TODO Auto-generated method stub
		return dao.fileInsert(attVo);
	}

	@Override
	public List<AttachedVO> attSearch(String att_bul) {
		// TODO Auto-generated method stub
		return dao.attSearch(att_bul);
	}



	
	
	
}
