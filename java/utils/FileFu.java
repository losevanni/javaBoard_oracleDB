package utils;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import org.apache.commons.text.StringEscapeUtils;


public class FileFu{
	public static MultipartRequest FileUpload(HttpServletRequest req, String saveDir, int maxFileSize) {
		try {

			return new MultipartRequest(req,saveDir,maxFileSize,"UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void FileDownload(HttpServletRequest req,HttpServletResponse res, String sfile, String ofile , ServletContext context)  {
//		String saveDir=context.getInitParameter("FilePath");
		String saveDir=context.getInitParameter("NEW_FilePath");
		File file = new File(saveDir, sfile);
		InputStream iStream = null;
		try {
		    FileInputStream fis = new FileInputStream(file);
		    BufferedInputStream bis = new BufferedInputStream(fis);
		    iStream = bis;
		    
		    res.reset();
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition",
					"attachment; filename=\""+ofile+"\"");
			OutputStream oStream=res.getOutputStream();
			
			byte b[] = new byte[(int)file.length()];
			int readBuffer=0;
			while((readBuffer=iStream.read(b))>0) {
				oStream.write(b,0,readBuffer);
			}
			iStream.close();
			oStream.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("no file i not find file???");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("[error] this error FileDownload error read me");
		    e.printStackTrace();
		}
	}
	public static MultipartRequest FileEditUpload(HttpServletRequest req, String saveDir, int maxFileSize) {
		try {
			
			return new MultipartRequest(req,saveDir,maxFileSize,"UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void FileDelete(String path, String filename) {
		File oldfile=new File(path+File.separator+filename);
		if(oldfile.exists()) {
			oldfile.delete();	
		}
	}
}
