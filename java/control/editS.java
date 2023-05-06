package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.board;
import model.boardUse;

/**
 * Servlet implementation class edit
 */
@WebServlet("/editS")
public class editS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boardUse dao=new boardUse();
		board dto = new board();
		String stridx = req.getParameter("idx");
		String pass=req.getParameter("pass");
		int idx = Integer.parseInt(stridx);
		try {
			dto = dao.detailPost(idx);
			dao.close();
		} catch (Exception e) {
			System.out.println("[error] edit fail");
			e.printStackTrace();
		}
		// pass not fail
		if(dto.getPass().equals(pass)) { 	
			req.setAttribute("edit", dto);
			req.getRequestDispatcher("Edit.jsp").forward(req,res);
		}else {
			res.sendRedirect("Fail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
