<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/board/boardMain.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/creboardList?userId=${LoginUser.userId}">게시글 생성 <span class="sr-only">(current)</span></a></li>
		<c:forEach items="${brdList}" var="vo">
			<li class="active"><a href="/freboardList?page=1&pageSize=10&brd_id=${vo.brd_id}">${vo.brd_name}</a></li>				
		</c:forEach>
	</ul>
</div>
</body>
</html>