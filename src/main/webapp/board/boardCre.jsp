<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/basicLib.jsp"%>

<script src="/js/jquery-3.3.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%-- header --%>
	<%@ include file="/common/boardHeader.jsp"%>
	<%-- left --%>
	<%@ include file="/common/boardLeft.jsp"%>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div>
			<h3>게시판 생성</h3>
		</div>

		<form method="post" action="/boardCre">
			게시판 이름 <input type="text" name="boardCre" id="boardCre"> <select
				name="creval" id="creval">
				<option>사용</option>
				<option>미사용</option>
			</select>
			<button type="submit" id="cre">생성</button>
			<br>
		</form>

		<div>
			<h3>게시판 수정</h3>
		</div>

		<c:forEach items="${brdList2}" var="vo">
			<form method="post" action="/boardUpdate">
				게시판 이름 <input type="hidden" name="brd_id" id="brd_id"
					value="${vo.brd_id}"> <input type="text" name="brd_name"
					id="brd_name" value="${vo.brd_name}">

				<c:choose>
					<c:when test="${vo.brd_chk==0}">
						<select id="opval" name="opval">
							<option selected="selected">사용</option>
							<option>미사용</option>
						</select>
					</c:when>
					<c:otherwise>
						<select id="opval" name="opval">
							<option>사용</option>
							<option selected="selected">미사용</option>
						</select>
					</c:otherwise>
				</c:choose>
				<button type="submit">수정</button>
				<br> <br>
			</form>
		</c:forEach>
	</div>

</body>
</html>