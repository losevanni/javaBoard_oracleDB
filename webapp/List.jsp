
<%@ include file="Nav.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.board" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<% 
	List<board> boardList=(ArrayList<board>)request.getAttribute("List");
%>
<%if(boardList!=null){ %>
<% for(board data : boardList) { %>
<div>
	<li><p>NUM: <%= data.getIdx() %></p>
	<p><a href="/detail_s?idx=<%= data.getIdx() %>"><h4>title: <%= data.getTitle() %></h4></a></p>
	<p>DATE: <%= data.getPostdate() %></p>
</div>
	 </li>
<% } %>
<% } %>

	
</ul>

</body>
</html>
