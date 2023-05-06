<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db shell</title>

</head>
<body>
<%
	Connection conn=null;
	try{
        Context initCtx = new InitialContext();
        Context ctx = (Context)initCtx.lookup("java:comp/env");
        DataSource source = (DataSource)ctx.lookup("DB19c");
        conn=source.getConnection();
	}catch(Exception e){
		out.println("fail connect");
	}
	
    PreparedStatement psmt=null;
    ResultSet rs=null;
    //String get=request.getParameter("q");
    //String query=get;
    String query="SELECT * FROM members";
    psmt=conn.prepareStatement(query);
    //psmt.setString(1,"losevanni");
    rs=psmt.executeQuery();
    while(rs.next()){ %>
    	<%= rs.getObject(1) %>
    	<%= rs.getObject(2) %>
    	<%= rs.getObject(3) %>
    <%
    }
%>

</body>
</html>