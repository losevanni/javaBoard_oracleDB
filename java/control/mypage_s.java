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
 * Servlet implementation class mypage_s
 */
@WebServlet("/mypage_s")
public class mypage_s extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypage_s() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		member user=new member();
		memberUse dao=new memberUse();
		String inputname="root";
		try {
			user=dao.selectMember(inputname);
			dao.close();
		} catch (Exception e) {
			System.out.println("adfdsfafasdfadfasfsdfdsfdasfsad fuck");
			e.printStackTrace();
		}
//		req.setAttribute("outid", user.getId() );
//		req.setAttribute("outname", user.getName() );
		req.setAttribute("user", user );
		req.getRequestDispatcher("MyPage.jsp").forward(req, res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
