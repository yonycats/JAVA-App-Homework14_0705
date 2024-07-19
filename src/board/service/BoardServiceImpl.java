package board.service;

import java.util.List;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao boardDao;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	private static IBoardService boardService = new BoardServiceImpl();
	
	public static IBoardService getInstance() {
		return boardService;
	}
	
	
	@Override
	public List<BoardVO> printAllSv(BoardVO bv) {
		return boardDao.printAll(bv);
	}

	@Override
	public int insertBoardSv(BoardVO bv) {
		return boardDao.insertBoard(bv);
	}

	@Override
	public int updateBoardSv(BoardVO bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deleteBoardSv(BoardVO bv) {
		return boardDao.deleteBoard(bv);
	}

	@Override
	public List<BoardVO> searchBoardSv(BoardVO bv) {
		return boardDao.searchBoard(bv);
	}

	@Override
	public List<BoardVO> dateSearchBoardSv(String param) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BoardVO detailBoardSv(String param) {
		return boardDao.detailBoard(param);
	}

}
