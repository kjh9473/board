package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface UserServiceInf {
	
	public List<UserVO> selectUserAll();
	
	public UserVO selectUser(String userId);
	
	public UserVO selectUser(UserVO userVo);
	
	/**
	* Method : selectUserPageList
	* 작성자 : pc25
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	public Map<String,Object> selectUserPageList(PageVO pageVo);
	
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
