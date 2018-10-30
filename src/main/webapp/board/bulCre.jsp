<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="favicon.ico" />

<%@include file="/common/basicLib.jsp"%>

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
					var chk = 1;
				$("#plus").click(function () {
					if(chk < 5 ){
						console.log(chk + " = chk");
						$(".gogo").append("<input type=\"file\" name= \"profile"+chk+"\"" + "id=\"profile"+chk+"\" />");
						++chk;
					}else{
						alert("파일은 5개만 가능합니다");
					}
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
				<form action="/bulCre" method="post" id="frm" enctype="multipart/form-data" role="form">
					
					<span>제목<span><input type = "text" name = "bul_title" id ="bul_title">
					<br><br>
					<span>글내용</span>
					<textarea name="smarteditor" id="smarteditor" rows="10" cols="100"
						style="width: 766px; height: 412px;"></textarea>
					
					
					<span>첨부파일</span>
					<br>
					<div class = "gogo">
						<input type="file" name="profile" id="profile">
					</div>
					<a id = "plus">&#43;[파일추가]</a>
					
					<%String bul_brd = request.getParameter("bul_brd"); %>
					<div>
						<input type = "hidden" id = "bul_brd" name = "bul_brd" value ="<%=bul_brd%>">
						<input type="button" id="savebutton" value="새글 등록" />
					</div>
				</form>
				<br>
			</div>
		</div>
	</div>
</body>
</html>