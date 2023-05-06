package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Errorfunc {
	public static void alertLocation(HttpServletResponse res, String msg, String url) {
		try {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer=res.getWriter();
			String script=""
					+"<script>"
					+" alert('" +msg+ "');"
					+" location.href='"+ url + "';"
					+"</script>";
			writer.print(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void alertBack(HttpServletResponse res, String msg) {
		try {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter writer=res.getWriter();
			String script=""
					+"<script>"
					+" alert('" +msg+ "');"
					+" history.back();"
					+"</script>";
			writer.print(script);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
