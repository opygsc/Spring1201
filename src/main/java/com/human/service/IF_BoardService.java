// 서비스단
package com.human.service;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_BoardService {
	public void insertOne(BoardVO bVo) throws Exception; // 컨트롤러에서 호출할 메서드

	public List<BoardVO> selectAll(PageVO pVo) throws Exception;
//	정의된 메서드는 컨트롤러가 호출하는 메서드, 구현은 DAO를 호출하는 메서드가 있을 것임
//	이름을 동일하게 쓰는 이유는 가독성때문임, 가독성도 상대적임
//	그래서 컨트롤러 <> 서비스 <> DAO를 먼저 이해하고, 이 기반에서 가독성을 이해해야 가독성이 좋다는 의미를 이해할 수 있음
	
	
	public BoardVO selectOne(String vNo) throws Exception; // 컨트롤러에서 호출할 메서드
	
	
	public void updateBoard(BoardVO bVo) throws Exception; // 컨트롤러에서 호출할 메서드
	
	public void deleteBoard(String vNo) throws Exception; // 컨트롤러에서 호출할 메서드
	
	
	public List<String> selectAttach(String vNo) throws Exception; // 컨트롤러에서 호출할 메서드
	
	
	public int countBoard() throws Exception; // 컨트롤러에서 호출할 메서드
	
	
	public void updateCnt(String vNo) throws Exception; // 컨트롤러에서 호출할 메서드
}