package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.member;
import model.memberUse;
/**
 * Servlet implementation class Join_s
 */
@WebServlet("/Join_s")
public class Join_s extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("join post");
		int result=0;
		memberUse dao =new memberUse();
		member dto =new member();
		String id= req.getParameter("id");
		String pw= req.getParameter("pw");
		String name= req.getParameter("name");
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		if(id==null||pw==null ||name==null) {
			res.sendRedirect("Fail.jsp");
		}
		try {
			result=dao.createMember(dto);
			dao.close();
		} catch (Exception e) {
			System.out.println("[error] Join_s fail ....... readme e.print");
			e.printStackTrace();
		}
		
		if(result==1) {// success login 
			System.out.println("succeses Join_s");
			res.sendRedirect("Login.jsp");
		}else {
			System.out.println("[error] Join_s fail");
			res.sendRedirect("Fail.jsp");
		}
	}
}
