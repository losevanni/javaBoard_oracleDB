package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.boardUse;
import model.board;
/**
 * Servlet implementation class detail_s
 */
@WebServlet("/detail_s")
public class detail_s extends HttpServlet {
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boardUse dao=new boardUse();
		board dto = new board();
		String stridx = req.getParameter("idx");
		int idx = Integer.parseInt(stridx);
		try {
			dto = dao.detailPost(idx);
			dao.close();
		} catch (Exception e) {
			System.out.println("[error] detail_s fail");
			e.printStackTrace();
			
		}
		dto.setPass(" ");
//		dto.setContent(dto.getContent().replaceAll("/r/n","<br/"));
		req.setAttribute("detail", dto);
		req.getRequestDispatcher("Detail.jsp").forward(req,res);
		//
	}
    
    protected void doPut(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		boardUse dao=new boardUse();
		board dto = new board();
    }

}
