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
<style type="text/css">
	.brdClick{
		cursor : pointer;
	}

	#bulIdd{
		display: none;
	}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		$(".brdClick").on("click",function(){
			var brdId = $(this).children()[0].innerText;
			$("#bulId").val(brdId);
			// .submit();
			$("#frm").submit();
		});
	});
	
</script>
<title></title>
</head>
<form id="frm" action="/brdDetail" method="get">
	<input type="hidden" id="bulId" name ="bulId"/>
</form>
<body>
	<%-- <%List<UserVO> userList =   (List<UserVO>)request.getAttribute("userList"); %> --%>
	<%-- header --%>
	<%@ include file="/common/boardHeader.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/boardLeft.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th id="bulIdd">dd</th>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>
								<c:forEach items="${bulList}" var="list" varStatus="status">
									<c:choose>
										<c:when test="${list.bul_chk == 0}">
											<tr class="brdClick">
												<td id="bulIdd">${list.bul_id }</td>
												<td>${list.rnum}</td>
												<td>${list.bul_title}</td>
												<td>${list.bul_mem}</td>
												<td><fmt:formatDate value="${list.bul_date}"
														pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td id="bulIdd">${list.bul_id }</td>
												<td>${list.rnum}</td>
												<td>${list.bul_title}</td>
												<td>${list.bul_mem}</td>
												<td><fmt:formatDate value="${list.bul_date}"
														pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</table>
						</div>

						<a class="btn btn-default pull-right" href ="/bulCre?bul_brd=${bul_brd}">새글 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li><a
									href="/freboardList?page=1&pageSize=10&brd_id=${bul_brd}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:choose>
									<c:when test="${bulSize==1}">
										<li><a
											href="/freboardList?page=${bulSize}&pageSize=10&brd_id=${bul_brd}"
											aria-label="Previous"> <span aria-hidden="true">&lt;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="/freboardList?page=${bulSize-1}&pageSize=10&brd_id=${bul_brd}"
											aria-label="Previous"> <span aria-hidden="true">&lt;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${bulSize==0}">
										<li><a href="/freboardList?page=1&pageSize=10&brd_id=${bul_brd}">1</a>
									</c:when>
									<c:when test="${bulSize!=0}">
										<c:forEach begin="0" end="${bulSize-1}" var="i">
											<li><a href="/freboardList?page=${i+1}&pageSize=10&brd_id=${bul_brd}">${i+1 }</a>
										</c:forEach>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${bulSize==bulSize}">
										<li><a
											href="/freboardList?page=${bulSize}&pageSize=10&brd_id=${bul_brd}"
											aria-label="Previous"> <span aria-hidden="true">&gt;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href="/freboardList?page=${bulSize+1}&pageSize=10&brd_id=${bul_brd}"
											aria-label="Previous"> <span aria-hidden="true">&gt;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<li><a
									href="/freboardList?page=${bulSize}&pageSize=10&brd_id=${bul_brd}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>