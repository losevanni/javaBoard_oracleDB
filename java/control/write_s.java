package control;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.oreilly.servlet.MultipartRequest;
import model.board;
import model.boardUse;
import utils.Errorfunc;
import utils.FileFu;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/write_s")
public class write_s extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("Write.jsp").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int result =0;
		boardUse dao = new boardUse();
		board dto=new board();
		ServletContext application=getServletContext();
		int maxFileSize=Integer.parseInt(application.getInitParameter("maxFileSize"));
//		String path=application.getInitParameter("FilePath");
		String path=application.getInitParameter("NEW_FilePath");
//		System.out.println(path);

		MultipartRequest mr=FileFu.FileUpload(req, path, maxFileSize);
		
		if(mr==null) {
			Errorfunc.alertLocation(res,"file is big ","index.jsp");
			System.out.println("[error] fail file upload ");
			return ;
		}
		
		dto.setId(mr.getParameter("id"));
		dto.setTitle(mr.getParameter("title"));
		dto.setContent(mr.getParameter("content"));
		dto.setPass(mr.getParameter("pass"));
		
		String filename=mr.getFilesystemName("ofile"); //if this filename== null  = no file upload use
		String newFileName="";
		String[] OKext= {".png",".txt",".jpg",".jsp"};
		
		if(filename!=null) {
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext=filename.substring(filename.lastIndexOf("."));
//			String ext1=ext.substring(ext.lastIndexOf(" "));
			
			
//			if(ext.equals(OKext[0]) || ext.equals(OKext[1])|| ext.equals(OKext[2]) || ext.equals(OKext[3]) ){
//			}else{
//				FileFu.FileDelete(path, filename);
//				res.sendRedirect("Fail.jsp");
//		}
			
			newFileName=now+ext;
			File oldFile=new File(path+File.separator+filename);
			File newFile=new File(path+File.separator+newFileName);
			
			oldFile.renameTo(newFile);
			
		}
		dto.setOfile(filename);
		dto.setSfile(newFileName);
		
		result=dao.createPost(dto);
		dao.close();
		if(result==1) {//success write
			System.out.println("write");
			res.sendRedirect("index.jsp");
		}else {//fail write
			System.out.println("no write");
			res.sendRedirect("Fail.jsp");
		}

	}

}
