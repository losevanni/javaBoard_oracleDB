package control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BoardPage;
import model.boardUse;
import model.board;

/**
 * Servlet implementation class board_s
 */
@WebServlet("/board_s")
public class board_s extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boardUse dao=new boardUse();
		List<board> list=new ArrayList<board>();
		list=dao.allPost();
		dao.close();
		req.setAttribute("List",list);
		req.getRequestDispatcher("List.jsp").forward(req, res);
		
	}

//search?
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doDelete() {
		
	}

}
