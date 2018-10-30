<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="favicon.ico" />

<%@include file="/common/basicLib.jsp"%>
<style type="text/css">
	#att_id{
		display: none;
	}
</style>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	$(document).ready(
			function() {
				// Editor Setting
				nhn.husky.EZCreator.createInIFrame({
					oAppRef : oEditors, // 전역변수 명과 동일해야 함.
					elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
					sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
					fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
					}
				});

				// 전송버튼 클릭이벤트
				$("#savebutton").click(
						function() {
							if (confirm("저장하시겠습니까?")) {
								// id가 smarteditor인 textarea에 에디터에서 대입
								oEditors.getById["smarteditor"].exec(
										"UPDATE_CONTENTS_FIELD", []);

								// 이부분에 에디터 validation 검증
								if (validation()) {
									$("#frm").submit();
								}
							}
						})
						
				$(document).on("click",".att_click",function(){
					var att_id = $(this).children()[0].innerText;
					alert(att_id + "확인");
// 					$("#bulId").val(att_id);
// 					// .submit();
// 					$("#frm").submit();
				});
			});

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '<p>&nbsp;</p>' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<%-- header --%>
	<%@ include file="/common/boardHeader.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/boardLeft.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="/bulUpdate" method="post" id="frm">
				
					<span>제목<span>
					<input type = "text" name = "bul_title" id ="bul_title" value = "${bulVo.bul_title}">
					<br><br>
					<span>글내용</span>
					<textarea name="smarteditor" id="smarteditor" rows="10" cols="100"
						style="width: 766px; height: 412px;">${bulVo.bul_text}</textarea>
					<p>첨부파일</p>
					<table>
					<c:forEach items="${attList}" var="att">
						<tr>
							<td id = "att_id">${att.att_id}</td>
							<td>${att.att_file}</td>
							<td class="att_click">삭제</td>
						</tr>
					</c:forEach>
					</table>
					<%String bul_brd = request.getParameter("bul_brd"); %>
					
					<input type = "hidden" id="bul_id" name = "bul_id" value ="${bulVo.bul_id }">
					<input type="button" id="savebutton" value="수정" />
				</form>
				<br>
			</div>
		</div>
	</div>
</body>
</html>