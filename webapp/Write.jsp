
<%@ include file="Nav.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/write_s" method="POST" enctype="multipart/form-data">
<div class="container mt-4">
<div class="input-group mb-3">
    <span class="input-group-text" id="basic-addon1">TITLE</span>
    <input type="text" class="form-control" placeholder="Title input" aria-label="Username" aria-describedby="basic-addon1" name="title">
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">ID</span>
  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="id">
</div>
<div class="input-group">
    <span class="input-group-text">With textarea</span>
    <textarea class="form-control" aria-label="With textarea" name="content"></textarea>
</div>
    <div class="input-group mb-3">
    <input type="file" class="form-control" id="inputGroupFile02" name="ofile">
    <label class="input-group-text" for="inputGroupFile02" >Upload File</label>
</div>
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">PASSWORD</span>
  <input type="password" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="pass">
</div>
<button type="submit" class="btn btn-warning">Write</button>
</div>
</form>
</body>
</html>
