package control;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.boardUse;
import utils.FileFu;
import model.board;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public delete() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int result=0;
		String stridx=req.getParameter("idx");
		int idx= Integer.parseInt(stridx);
		String pass=req.getParameter("pass");
		ServletContext application=getServletContext();
		String path=application.getInitParameter("FilePath");
		boardUse dao=new boardUse();
		board dto=new board();
		dto=dao.detailPost(idx);
		if(!dto.getPass().equals(pass)) {
			res.sendRedirect("Fail.jsp");
		}
		if(dto.getSfile()!=null) {  // if file in delete
			FileFu.FileDelete(path,dto.getSfile());
		}
			
		result=dao.deletePost(idx);
		if(result==1) {
			res.sendRedirect("index.jsp");
		}else {
			res.sendRedirect("Fail.jsp");
		}
		
	}

}
