<%@ include file="Nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="common.JDBConnect"%>
<%@ page import="common.DBConnPool"%>
<!DOCTYPE html>
<html>
<head>
  <title>web_ssr</title>

</head>
<body>
<h1><%= "Hi I am ssr website I hate you " %></h1>
<h3><%= "this web site bad site"%> </h3>
<br>
<h5>All page link list</h5>
<h6>simple is the bast</h6>
<br/>
<ul class="list-group">
  <li class="list-group-item">
    <a href="board_s">List All view</a>
  </li>
  <li class="list-group-item">
    <a href="Write.jsp">Write new post </a>
  </li>
  <li class="list-group-item">
    <a href="Edit.jsp">Edit post</a>
  </li>
  <li class="list-group-item">
  <a href="Login.jsp">Login</a></li>
  <li class="list-group-item">
  <a href="Join.jsp">Join</a></li>
</ul>







  
</body>
</html>