package board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/insert.do")
public class InsertBoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/board/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("InsertBoardController");
		
		IBoardService boardService = BoardServiceImpl.getInstance();

		BoardVO bv = new BoardVO();

		try {
			BeanUtils.populate(bv, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		int cnt = boardService.insertBoardSv(bv);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		
		resp.getWriter().print(cnt);
	}
}
