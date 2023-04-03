
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="common.JDBConnect"%>
<!DOCTYPE html>
<html>
<head>
  <title>web_ssr</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1><%= "Hi I am ssr website I hate you " %></h1>
<h3><%= "this web site bad site"%> </h3>
<br>
<h5>All page list</h5>
<br/>
<ul class="list-group">
  <li class="list-group-item">
    <a href="List.jsp">List All view</a>
  </li>
  <li class="list-group-item">
    <a href="View.jsp">View detail</a>
  </li>
  <li class="list-group-item">
    <a href="Write.jsp">Write new post </a>
  </li>
  <li class="list-group-item">
    <a href="Edit.jsp">Edit post</a>
  </li>
  <li class="list-group-item"><a href="Login.jsp">Login</a></li>
  <li class="list-group-item"><a href="Join.jsp">Join</a> </li>
</ul>
<a href="/test"></a>

<h6>jdbc test</h6>

<%JDBConnect db=new JDBConnect(application);
db.close();
%>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>