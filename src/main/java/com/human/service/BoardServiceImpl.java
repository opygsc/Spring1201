// 서비스단
package com.human.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.human.dao.IF_BoardDAO;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Service // 서비스 단임을 알려줌, 해당 클래스를 루트 컨테이너에 Bean 객체로 생성해주는 어노테이션
public class BoardServiceImpl implements IF_BoardService {
	
	@Inject // 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입
	private IF_BoardDAO bDao;

	@Override
	public void insertOne(BoardVO bVo) throws Exception {
//		board1201 table insert
//		board1201_attach table insert
		bDao.insertOne(bVo);
		String[] fName = bVo.getFiles();
		if (fName != null) {
			for (int i = 0; i < fName.length; i++) {
				if (fName[i] != null) {
					System.out.println(fName[i] +"file name chk");
					bDao.insertAttach(fName[i]);
				}
			}
		}
	}

	@Override
	public List<BoardVO> selectAll(PageVO pVo) throws Exception {
		return bDao.selectAll(pVo);
	}
	

	@Override
	public BoardVO selectOne(String vNo) throws Exception {
		return bDao.selectOne(vNo);
	}

	
	@Override
	public void updateBoard(BoardVO bVo) throws Exception {
		bDao.updateBoard(bVo);
	}
	
	@Override
	public void deleteBoard(String vNo) throws Exception {
		bDao.deleteBoard(vNo);
	}

	
	@Override
	public List<String> selectAttach(String vNo) throws Exception {
		return bDao.selectAttach(vNo);
	}
	
	
	@Override
	public int countBoard() throws Exception {
		return bDao.countBoard();
	}

	
	@Override
	public void updateCnt(String vNo) throws Exception {
		bDao.updateCnt(vNo);
	}
}