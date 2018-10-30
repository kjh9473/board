package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface UserDaoInf {
	
	public List<UserVO> selectUserAll();
	
	public UserVO selectUser(String userId);
	
	public UserVO selectUser(UserVO userVo);
	
	public List<UserVO> selectUserPageList(PageVO pageVo);
	
	/**
	* Method : getUserCnt
	* 작성자 : pc25
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	int getUserCnt();
	
	/**
	* Method : insertUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	int insertUser(UserVO userVo);
	
	/**
	* Method : deleteUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	int deleteUser(String userId);
	
	
	/**
	* Method : updateUser
	* 작성자 : pc25
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보수정
	*/
	int updateUser(UserVO userVo);
}
