<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<%@include file="/common/basicLib.jsp"%>

<title>게사판 조회</title>
</head>


<body>
	<%-- header --%>
	<%@ include file="/common/boardHeader.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/boardLeft.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" method="get"
					action="/bulUpdate">

					<%@ include file="/common/basicLib.jsp"%>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${bulVo.bul_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${bulVo.bul_text}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach items="${attList}" var="att">
								<label class="control-label">${att.att_file}</label><br>
							</c:forEach>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-10">
							<input type="hidden" class="btn btn-default" id="bul_id"
								name="bul_id" value="${bulVo.bul_id}">
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-10">
							<label for="userNm" class="col-sm-2 control-label"></label> <input
								type="submit" class="btn btn-default" value="수정">
						</div>
					</div>
				</form>




				<form method="post" action="/bulDelete">

					<div class="form-group">
						<div class="col-sm-10">
							<input type="hidden" class="btn btn-default" id="bul_id"
								name="bul_id" value="${bulVo.bul_id}">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-10">
							<label for="userNm" class="col-sm-2 control-label"></label> <input
								type="submit" class="btn btn-default" value="삭제">
						</div>
					</div>
				</form>




				<form method="get" action="/bulReply">

					<div class="form-group">
						<div class="col-sm-10">
							<input type="hidden" class="btn btn-default" id="bul_id"
								name="bul_id" value="${bulVo.bul_id}">
						</div>
					</div>

					<div>
						<div class="form-group">
							<div class="col-sm-10">
								<input type="hidden" class="btn btn-default" id="bul_brd"
									name="bul_brd" value="${bulVo.bul_brd}">
							</div>
						</div>


						<div class="form-group">
							<div class="col-sm-10">
								<label for="userNm" class="col-sm-2 control-label"></label> <input
									type="submit" class="btn btn-default" value="답글">
							</div>
						</div>
				</form>

				<div class="form-group">
					<label for="userNm" class="col-sm-2 control-label">댓글</label>
					<div class="col-sm-10">
						<c:forEach items="${comList}" var="list" varStatus="status">
							<form method="post" action="/comDelete">
								<input type="hidden" id="comid" name="comid"
									value="${list.com_id}"> <input type="hidden"
									id="com_bul" name="com_bul" value="${list.com_bul}"> <label
									class="control-label">${list.com_text}[${list.com_mem}/${list.com_date}]</label>
								<c:if test="${list.com_mem == userId}">
									<button type="submit">삭제</button>
								</c:if>
								<br>
							</form>
						</c:forEach>
					</div>
				</div>


				<form method="post" action="/comCre">

					<div class="form-group">
						<div class="col-sm-10">
							<input type="hidden" class="btn btn-default" id="bul_id"
								name="bul_id" value="${bulVo.bul_id}">
						</div>
					</div>



					<div class="form-group">
						<div class="col-sm-10">
							<label for="userNm" class="col-sm-2 control-label"></label> <input
								type="text" id="ripple" name="ripple" size="50">
							<button type="submit">댓글 등록</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>



</body>
</html>