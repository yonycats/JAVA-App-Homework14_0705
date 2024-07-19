package board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import board.util.MyBatisUtil;
import board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {
	}
	
	public static IBoardDao getInstance() {
		return boardDao;
	}
	
	SqlSession session = null;
	
	
	@Override
	public List<BoardVO> printAll(BoardVO bv) {
		SqlSession session = MyBatisUtil.getSqlSession(true);

		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			list = session.selectList("Board.printAllBoard", bv);

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		session = MyBatisUtil.getSqlSession();

		int cnt = 0;
		
		try {
			cnt = session.insert("Board.insertBoard", bv);	
			
			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			System.out.println("insert에 오타남");
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {

		session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("Board.updateBoard", bv);
			
			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			System.out.println("update에 오타남");
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public int deleteBoard(BoardVO bv) {

		session = MyBatisUtil.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("Board.deleteBoard", bv);
			
			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			System.out.println("delete에 오타남");
			session.rollback();
		} finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		session = MyBatisUtil.getSqlSession();
		
		try {
			boardList = session.selectOne(".", bv);

			session.commit();

		} catch (PersistenceException e) {
			System.out.println("search에 오타남");
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public List<BoardVO> dateSearchBoard(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO detailBoard(String param) {

		session = MyBatisUtil.getSqlSession(true);
		
		BoardVO result = new BoardVO();
		
		try {
			result = session.selectOne("Board.detailBoard", param);
			
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}

		return result;
	}

}
