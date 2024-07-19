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

@WebServlet("/board/detail.do")
public class DetailBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("DetailBoardController");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		String boardNo = req.getParameter("boardNo");
		BoardVO bv = boardService.detailBoardSv(boardNo);
		
		bv.toString();
		
		req.setAttribute("bv", bv);
		
		req.getRequestDispatcher("/views/board/detail.jsp").forward(req, resp);
	}
	
}
