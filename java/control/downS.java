package control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLEditorKit.Parser;
import model.boardUse;
import model.board;
import utils.FileFu;

@WebServlet("/downS")
public class downS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public downS() {
        super();

    }
    private ServletContext context;

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
		String ofile =req.getParameter("ofile");
		String sfile="";
		String stridx =req.getParameter("idx");
		int idx = Integer.parseInt(stridx);
		boardUse dao=new boardUse();
		board dto=new board();
		dto=dao.detailPost(idx);
		dao.close();
		try {
			context=getServletContext();
		} catch (Exception e) {
			System.out.println("no context downS doget error");
			e.printStackTrace();
			res.sendRedirect("Fail.jsp");
		}
		
		// file name == file db , file in db 
		if (!dto.getOfile().equals(ofile)) {
			System.out.println();
			res.sendRedirect("Fail.jsp");
		}
//		String sfile=req.getParameter("sfile");
		
		ofile=dto.getOfile();
		sfile=dto.getSfile();
		FileFu.FileDownload(req,res,sfile,ofile,context);
	}


}
