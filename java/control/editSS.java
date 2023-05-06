package control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.board;
import model.boardUse;
import utils.Errorfunc;
import utils.FileFu;




@WebServlet("/editSS")
public class editSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSS() {
        super();
        // TODO Auto-generated constructor stub
    }
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			int result =0;
			boardUse dao = new boardUse();
			board dto=new board();
			ServletContext application=getServletContext();
			int maxFileSize=Integer.parseInt(application.getInitParameter("maxFileSize"));
			String path=application.getInitParameter("FilePath");			
			String saveDir=path;
			MultipartRequest mr=FileFu.FileUpload(req, saveDir, maxFileSize);
			
			if(mr==null) {
				Errorfunc.alertLocation(res,"file is big ","index.jsp");
				System.out.println("[error] fail file upload ");
				return ;
			}
			
			dto.setId(mr.getParameter("id"));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setPass(mr.getParameter("pass"));
			String oldpasswd=mr.getParameter("oldpass");
			String stridx=mr.getParameter("idx");
			int idx = Integer.parseInt(stridx);
			dto.setIdx(idx);
			board old=new board();
			old=dao.detailPost(idx);
			String filename=mr.getFilesystemName("ofile"); //if this filename== null  = no file upload use
			if(!old.getPass().equals(oldpasswd)) { // pass fail is delete file file name is ofile
				FileFu.FileDelete(path,filename);
				System.out.println("dasfdsafasdfasfasdfsdfasfdf");
				res.sendRedirect("Fail.jsp");
			}
			
			String newFileName="";
			
			// no newup , yes newup, yes noup ,no noup 
			if(filename!=null) {
				if(old.getOfile()==null) { // no old file
					String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
					String ext=filename.substring(filename.lastIndexOf("."));
					newFileName=now+ext;
					File oldFile=new File(saveDir+File.separator+filename);
					File newFile=new File(saveDir+File.separator+newFileName);
					oldFile.renameTo(newFile);
					dto.setOfile(filename);
					dto.setSfile(newFileName);
				}else { // file yes no up
					// old file delete
					FileFu.FileDelete(saveDir,old.getSfile());
					System.out.println("filename= in , change file");
					
					String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
					String ext=filename.substring(filename.lastIndexOf("."));
					newFileName=now+ext;
					File saveFile=new File(saveDir+File.separator+filename);
					File newFile=new File(saveDir+File.separator+newFileName);
					saveFile.renameTo(newFile);
					dto.setOfile(filename);
					dto.setSfile(newFileName);
				}
			}else {
				if(old.getOfile()!=null) { //file yes , no up
					dto.setOfile(old.getOfile());
					dto.setSfile(old.getSfile());
				}else { // file no , no up  == null,null
					dto.setOfile(filename);
					dto.setSfile(newFileName);
				}
			}
			result=dao.updatePost(dto);
			
			
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
