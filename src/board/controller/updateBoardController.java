package board.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/update.do")
public class updateBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		String boardNo = req.getParameter("boardNo");
		
		BoardVO bv = boardService.detailBoardSv(boardNo);
		
		req.setAttribute("bv", bv);
		
		req.getRequestDispatcher("/views/board/updateForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBoardService boardService = BoardServiceImpl.getInstance();

		BigDecimal boardNo = new BigDecimal(req.getParameter("boardNo"));
		String boardWriter = req.getParameter("boardWriter");
		String boardTitle = req.getParameter("boardTitle");
		String boardContent = req.getParameter("boardContent");
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardWriter(boardWriter);
		bv.setBoardTitle(boardTitle);
		bv.setBoardContent(boardContent);

		System.out.println(bv.toString());
		
		int cnt = boardService.updateBoardSv(bv);
		
		System.out.println("cnt : " + cnt);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/board/detail.do?boardNo=" + req.getParameter("boardNo"));
	}
	
}
