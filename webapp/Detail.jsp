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
        <h4 class="text-center">상세 페이지</h4>
        <div class="card" style="width: 100%;">
            <div class="card-body">
                <h5 class="card-title">제목:  ${detail.title } </h5>
                <h6 class="card-subtitle mb-2 text-muted">날짜: ${detail.postdate } </h6>
                <p type="hidden" id="number" value="${ detail.idx }"></p>
                
                <p class="card-text" >내용 ${detail.content} </p>
                <form action="downS" method="POST">
                	<input type="hidden" name="ofile" value="${ detail.ofile }">
                	<input type="hidden" name="idx" value="${ detail.idx }">
                	<input type="hidden" name="sfile" value="${ detail.sfile }">
                	<button type="submit"><p>${ detail.ofile } DownLoad</p> </button>
                </form>
                <p>sfile name is ${ detail.sfile }</p>
                
                <div class="input-group mb-3">
		<form id="myForm" method="POST">
		  <input type="hidden" name="idx" value= ${ detail.idx } ></input>
		  <input type="password" placeholder="PASS" name="pass" id="inputValue" class="form-control">
		  <button type="submit" onclick=submitForm('editS')>edit</button>
		  <button type="submit" onclick=submitForm('delete')>delete</button>
		</form>

<script>
  function submitForm(url) {
    var form = document.getElementById("myForm");
    
    
    form.action = url;
    form.submit();
  }
</script>
                    

  
            </div>
        </div>
    </div>
</body>
</html>