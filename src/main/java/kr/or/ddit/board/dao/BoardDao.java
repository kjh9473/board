package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.AttachedVO;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.model.BulletinVO;
import kr.or.ddit.board.model.CommentsVO;
import kr.or.ddit.db.SqlFactoryBuilder;

public class BoardDao implements BoardDaoInf {

	@Override
	public List<BulletinVO> selectBulletinList(Map<String, Object> map) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BulletinVO> bulList = session.selectList("board.selectBulletinList",map);
		session.close();
		
		return bulList;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVO> brdList = session.selectList("board.selectBoardList");
		session.close();
		
		return brdList;
	}

	@Override
	public int BulletinCnt(String bul_brd) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int Size = session.selectOne("board.BulletinCnt",bul_brd);
		session.close();
		
		return Size;
	}

	@Override
	public int insertBrd(BoardVO brdVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("board.insertBrd",brdVo);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int updateBrd(BoardVO brdVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.update("board.updateBrd",brdVo);
		
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public List<BoardVO> allBoardList(String brd_mem) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<BoardVO> brdList = session.selectList("board.allBoardList",brd_mem);
		session.close();
		
		return brdList;
	}

	@Override
	public BulletinVO searchBul(String bul_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		BulletinVO bulVo = session.selectOne("board.searchBul",bul_id);
		session.close();
		
		return bulVo;
	}

	@Override
	public int insertBul(BulletinVO bulVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("board.insertBul",bulVo);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int bulUpdate(BulletinVO bulVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.update("board.bulUpdate",bulVo);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int bulDelete(String bul_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.update("board.bulDelete",bul_id);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int bulReply(BulletinVO bulVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("board.bulReply",bulVo);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int comInsert(CommentsVO comVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("board.comInsert",comVo);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public List<CommentsVO> comSearch(String com_bul) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<CommentsVO> comList = session.selectList("board.comSearch",com_bul);
		session.close();
		
		return comList;
	}

	@Override
	public int comDelete(String com_id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.update("board.comDelete",com_id);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int fileInsert(AttachedVO attVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("board.fileInsert",attVo);
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public List<AttachedVO> attSearch(String att_bul) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<AttachedVO> attList = session.selectList("board.attSearch",att_bul);
		session.close();
		
		return attList;
	}

	

	

	
}
