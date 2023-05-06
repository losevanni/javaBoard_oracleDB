<%@ page contentType="text/html; charset=utf-8" %> 
<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %> 
<% 

Connection con = null; 
PreparedStatement pstmt = null; 
ResultSet rs = null; 

try{ 
	Context initCtx = new InitialContext();  //네이밍 조작을 실행하기 위한 개시 컨텍스트
	DataSource ds = (DataSource)initCtx.lookup("DB19c"); 
	con = ds.getConnection(); 
	pstmt = con.prepareStatement("select user from dual"); 
	rs = pstmt.executeQuery(); 
	int i=1; 
	while(rs.next()) { 
		i++; 
		out.println("<html>");
		out.println("<head><title>Result</title></head>");
		out.println("<body>");
		out.println("<p>User: " + rs.getString("user") + "</p>");
		out.println("</body>");
		out.println("</html>");
	} 
} catch(Exception e) { 
	e.printStackTrace(); 
	out.println(e.getMessage()); 
} finally { 
	con.close(); 
	pstmt.close(); 
	rs.close(); 
} 
%>