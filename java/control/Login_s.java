package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import model.member;
import model.memberUse;

@WebServlet("/Login_s")
public class Login_s extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		boolean result =false;
		memberUse dao=new memberUse();
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		if(id==null || pw==null) {
			res.sendRedirect("Fail.jsp");
			System.out.println("no user input id pw");
		}
		try {
			result=dao.compareMember(id,pw);
			
			dao.close();
		} catch (Exception e) {
			System.out.println("[error] Login_fail");
			e.printStackTrace();
		}
		if(result==true) {
			System.out.println("success login");	
			// session id send
			res.sendRedirect("index.jsp");
//			res.addCookie(null);
			
		}else {
			System.out.println("[fail] dont your info have");
			req.setAttribute("log","login fail  real?");
			req.getRequestDispatcher("Login.jsp").forward(req, res);;
		}
	}

}
