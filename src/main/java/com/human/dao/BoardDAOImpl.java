// DAO단
package com.human.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Repository // DAO 단임을 알려줌
public class BoardDAOImpl implements IF_BoardDAO {

//	Spring의 DAO와 Mybatis sqlSession을 연결하는 객체	
	private static String mapperQuery = "com.human.dao.IF_BoardDAO";

//	Mybatis의 sqlSession 객체가 필요함
	@Inject // 컨테이너에서 가져와야함, 컨테이너에서 주입하려고 하는 객체의 타입이 맞는 객체의 주소를 자동으로 주입
	private SqlSession sqlSession;  // SqlSession 타입의 객체는 Spring 컨테이너에 있음
									// 여기서 이 객체가 필요함, 그런데 컨테이너에서 가져와야 함
									// 스프링은 DI 개념

	@Override
	public void insertOne(BoardVO bVo) throws Exception {
		sqlSession.insert(mapperQuery + ".insertOne", bVo); // 쿼리를 맵핑 및 실행
//				<insert>	맵핑정보			ID		parameter
	}

	@Override
	public List<BoardVO> selectAll(PageVO pVo) throws Exception {
		return sqlSession.selectList(mapperQuery + ".selectAll", pVo); // 쿼리를 맵핑 및 실행
//							<select>	맵핑정보			ID		parameter
	}
	
	
	@Override
	public BoardVO selectOne(String vNo) throws Exception {
		return sqlSession.selectOne(mapperQuery + ".selectOne", vNo); // 쿼리를 맵핑 및 실행
//							<select>	맵핑정보			ID		parameter
	}

	
	@Override
	public void updateBoard(BoardVO bVo) throws Exception {
		sqlSession.update(mapperQuery + ".updateBoard", bVo); // 쿼리를 맵핑 및 실행
//				<update>	맵핑정보			ID		parameter
	}
	
	@Override
	public void deleteBoard(String vNo) throws Exception {
		sqlSession.delete(mapperQuery + ".deleteBoard", vNo); // 쿼리를 맵핑 및 실행
//				<delete>	맵핑정보			ID		parameter
	}

	
	@Override
	public void insertAttach(String fileName) throws Exception {
		sqlSession.insert(mapperQuery + ".boardAttach", fileName); // 쿼리를 맵핑 및 실행
//					<insert>	맵핑정보			ID		parameter
	}

	@Override
	public List<String> selectAttach(String vNo) throws Exception {
		return sqlSession.selectList(mapperQuery + ".selectAttach", vNo); // 쿼리를 맵핑 및 실행
//							<select>	맵핑정보			ID		parameter
	}
	
	
	@Override
	public int countBoard() throws Exception {
		return sqlSession.selectOne(mapperQuery + ".countBoard"); // 쿼리를 맵핑 및 실행
//							<select>	맵핑정보			ID
	}

	
	@Override
	public void updateCnt(String vNo) throws Exception {
		sqlSession.update(mapperQuery + ".cntPlus", vNo); // 쿼리를 맵핑 및 실행
//				<update>	맵핑정보			ID		parameter
	}
}