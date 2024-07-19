package board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/delete.do")
public class DeleteBoardController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DeleteBoardController");
		
		IBoardService boardService = BoardServiceImpl.getInstance();

		BoardVO bv = new BoardVO();
		
		try {
			BeanUtils.populate(bv, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		int cnt = boardService.deleteBoardSv(bv);
		
		String msg = "";
		
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/board/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
