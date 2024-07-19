package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/list.do")
public class ListBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("ListBoardController");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		BoardVO bv = new BoardVO();
		List<BoardVO> boardList = boardService.printAllSv(bv);
		
		for (BoardVO boardVO : boardList) {
			boardVO.getBoardTitle();
		}
		
		req.setAttribute("boardList", boardList);
		
		req.getRequestDispatcher("/views/board/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
