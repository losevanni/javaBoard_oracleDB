<%@ include file="Nav.jsp" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h4 class="text-center">상세 페이지 UPDATE</h4>
        <div class="card" style="width: 100%;">
            <div class="card-body">
	<form action="/editSS" method="POST" enctype="multipart/form-data">
                    <div class="container mt-4">
                    <div class="input-group mb-3">
                        <span class="input-group-text" id="basic-addon1">TITLE</span>
                        <input type="hidden" name="idx" value="${ edit.idx }">
                        <input type="text" class="form-control" placeholder="${ edit.title }" aria-label="Username" aria-describedby="basic-addon1" name="title">
                    </div>
                    <div class="input-group mb-3">
                      <span class="input-group-text" id="basic-addon1">ID</span>
                      <input type="text" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1" name="id">
                    </div>
                    <div class="input-group">
                        <span class="input-group-text">With textarea</span>
                        <textarea class="form-control" aria-label="With textarea" placeholder="${ edit.content }" name="content"></textarea>
                    </div>
                        <div class="input-group mb-3">
                        <input type="file" class="form-control" id="inputGroupFile02" name="ofile">
                        <label class="input-group-text" for="inputGroupFile02" >Upload File</label>
                    </div>
                    <div class="input-group mb-3">
                      <span class="input-group-text" id="basic-addon1">PASS</span>
                      <input type="password" class="form-control" placeholder="NEW PASS" aria-label="Username" aria-describedby="basic-addon1" name="pass">
                      <span class="input-group-text" id="basic-addon1">OLD PASS</span>
                      <input type="password" class="form-control" placeholder="old PASS" aria-label="Username" aria-describedby="basic-addon1" name="oldpass">
                    </div>
                    <button type="submit" class="btn btn-warning">Modify</button>
                    </div>
                    </form>
                <p class="card-text"></p>

                
                    

                <!-- 기능 구현 필요 -->
                <a href="/detail_s?idx=${ edit.idx }" class="card-link">수정 하기</a>
                <a href="/list" class="card-link">삭제 하기</a>
            </div>
        </div>
    </div>

</body>
</html>