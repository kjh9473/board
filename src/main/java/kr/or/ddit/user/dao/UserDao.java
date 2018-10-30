package kr.or.ddit.user.dao;


import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	public List<UserVO> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVO> userList = session.selectList("user.selectUserAll");
		//selectOne : 데이터 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이.쿼리id 
		session.close();
		
		return userList;
	}
	
	public UserVO selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVO userVo = session.selectOne("user.selectUser",userId);
		session.close();
		
		return userVo;
		
	}
	
	public UserVO selectUser(UserVO userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		UserVO userVo2 = session.selectOne("user.selectUserByVo",userVo);
		
		session.close();
		
		return userVo2;
		
	}

	@Override
	public List<UserVO> selectUserPageList(PageVO pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVO> userList = session.selectList("user.selectUserPageList",pageVo);
		
		session.close();
		
		return userList;
	}
	
	
	/**
	* Method : getUserCnt
	* 작성자 : pc25
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}
	
	/**
	* Method : insertUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVO userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.insert("user.insertUser",userVo);
		
		session.commit();
		session.close();
		
		return result;
	}
	
	/**
	* Method : deleteUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.delete("user.deleteUser",userId);
		
		session.commit();
		session.close();
		
		return result;
	}
	
	/**
	* Method : updateUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보수정
	*/
	@Override
	public int updateUser(UserVO userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int result = session.update("user.updateUser",userVo);
		
		session.commit();
		session.close();
		
		return result;
	}
}
