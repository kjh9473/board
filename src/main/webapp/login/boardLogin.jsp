<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/basicLib.jsp"%>
<link href="/css/signin.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function () {
		console.log("test");
		//remember 쿠키값이 Y이면
		//remember-mem 체크박스 체크
		//userId input value를 userId 쿠키 값을 설정
		var chk = getCooKie("remember");
		console.log(chk);
		if(chk == "Y"){
// 			document.getElementById("remember").checked = true;
			$("#remember").attr("checked",true);
// 			$("#remember").prop("checked",true);
			var userId = getCooKie("userId");
			$("#inputId").val(userId);
		}
		else{
			$("#inputId").val("");
		}
	});


	function getCooKie(cookieName) {
		var cookie = document.cookie;
		var array = cookie.split('; ');
		var cookieValue = "";

		for ( var i in array) {
			if (array[i].indexOf(cookieName) >= 0) {
				cookieValue = array[i].substring(array[i].indexOf("=") + 1);
			}
		}
		return cookieValue;
	}
	
</script>
</head>
<body>
	<%-- 
	브라우저 주소줄에 입력한 경우 : get
	form 태그의 method 속성 : get/post 
--%>
	<div class="container">
		<form action="/boardLogin" method=post class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input	type="text" id="inputId" class="form-control" 
				placeholder="ID를 넣어주세요" required="" autofocus="" name="userId"	> 
			<label for="inputPW" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" name="password">

			<div class="checkbox">
				<label> 
					<input type="checkbox" class ="remember-me" name="remember-me" value = "remember" id = "remember"> 
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
		</form>
	</div>
</body>
</html>