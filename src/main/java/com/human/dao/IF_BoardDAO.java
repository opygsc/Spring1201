// DAO단
package com.human.dao;

import java.util.List;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_BoardDAO {
	
	public void insertOne(BoardVO bVo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드

	public List<BoardVO> selectAll(PageVO pVo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	
	public BoardVO selectOne(String vNo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	
	public void updateBoard(BoardVO bVo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	public void deleteBoard(String vNo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	
	public void insertAttach(String fileName) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	public List<String> selectAttach(String vNo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	
	public int countBoard() throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
	
	
	public void updateCnt(String vNo) throws Exception; // 서비스단에서 호출할 메서드이면서 맵핑에 사용할 메서드
}