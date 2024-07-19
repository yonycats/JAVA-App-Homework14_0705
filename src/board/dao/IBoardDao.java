package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface IBoardDao {

	/**
	 * BoardVO에 담긴 게시물 정보를 전부 출력하기 위한 메서드
	 * @return 모든 게시물 정보를 담은 BoardVO객체
	 */
	public List<BoardVO> printAll(BoardVO bv);
	
	/**
	 * BoardVO에 담겨진 게시물 정보를 DB에 insert하기 위한 메서드
	 * @param bv 게시물 정보를 담은 BoardVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * BoardVO에 담겨진 게시물 정보를 DB에 update하기 위한 메서드
	 * @param bv 게시물 정보를 담은 BoardVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 해당 게시물 번호에 해당하는 게시물을 삭제하기 위한 메서드
	 * @param 삭제할 BOARD_NO를 확인하기 위한 게시물 번호가 담긴 BoardVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨
	 */
	public int deleteBoard(BoardVO bv);
	
	/**
	 * BoardVO에 담긴 작성자, 제목, 내용과 관련된 게시물을 찾기 위한 메서드
	 * @param 검색하길 원하는 게시물의 날짜/작성자/제목/내용 정보가 담긴 BoardVO 객체
	 * @return 해당 글이 존재하면  true, 존재하지 않으면 false 리턴함
	 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
	/**
	 * String에 담긴 날짜와 관련된 게시물을 찾기 위한 메서드
	 * @param 검색하길 원하는 게시물의 날짜 정보가 담긴 String 객체
	 * @return 해당 글이 존재하면  true, 존재하지 않으면 false 리턴함
	 */
	public List<BoardVO> dateSearchBoard(String param);
	
	/**
	 * String에 담긴 게시물 번호와 관련된 게시물을 찾기 위한 메서드
	 * @param 검색하길 원하는 게시물의 게시물 번호가 담긴 String 객체
	 * @return 해당 글이 존재하면  true, 존재하지 않으면 false 리턴함
	 */
	public BoardVO detailBoard(String param);
	
}
