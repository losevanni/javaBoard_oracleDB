<%@ include file="Nav.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="model.boardUse" %>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
	<form action="/Join_s" method="POST">
		<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">ID</span>
  <input type="text" class="form-control" placeholder="new id" aria-label="Username" aria-describedby="basic-addon1" name="id">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">PW</span>
  <input type="text" class="form-control" placeholder="new passward" aria-label="Username" aria-describedby="basic-addon1" name="pw">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">NAME</span>
  <input type="text" class="form-control" placeholder="name" aria-label="Username" aria-describedby="basic-addon1" name="name">
</div>	
<button type="submit" class="btn btn-success">Create</button>
	</form>
</div>


</body>
</html>