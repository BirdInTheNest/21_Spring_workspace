<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>이미지 등록</h3>

<%-- 1. 단순 submit ~ action
<form id="imageboardWriteForm" enctype="multipart/form-data" method="post" 
action="/chapter06_SpringWebMaven/user/imageboardWrite"> --%>

<!-- 2. AJax 통신 -->
<form id="imageboardWriteForm">
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<td width="100" align="center">상품코드</td>
			<td>
				<input type="text" id="imageId" name="imageId" size="50" value="img_"><!-- value를 날짜시간으로 할 수도 있다 -->
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">상품명</td>
			<td>
				<input type="text" id="imageName" name="imageName" size="50" placeholder="상품명 입력">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">단가</td>
			<td>
				<input type="text" id="imagePrice" name="imagePrice" size="50" placeholder="단가 입력">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">개수</td>
			<td>
				<input type="text" id="imageQty" name="imageQty" size="50" placeholder="개수 입력">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea cols="50" rows="15" id="imageContent" name="imageContent"></textarea>
			</td>
		</tr>
		
		<!-- <tr>
			<td colspan="2">
				<input type="file" name="img">다중 파일 업로드: name속성에 같은 이름을 지정
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="file" name="img">
			</td>
		</tr> -->
		
		<tr>
			<td colspan="2">
				<input type="file" name="img[]" multiple><!-- 한번에 여러개의 파일을 선택한 경우 -->
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="imageboardWriteBtn" value="이미지등록">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$('#imageboardWriteBtn').click(function(){
		//1. 단순 submit ~ action
		//$('#imageboardWriteForm').submit();
		
		//2. AJax 통신 - FormData 클래스의 내장객체 forms를 사용하기 때문에, 배열 인덱스 표시해야 한다
		var formData = new FormData($('#imageboardWriteForm')[0]); //0번째 폼 안에 있는 모든 데이터 		
			
		$.ajax({
			url: '/chapter06_SpringWebMaven/user/imageboardWrite',
			type: 'post',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(){
				alert('이미지 등록 완료');
			},
			error: function(err){
				console.log(err);
			}
		});
		
	});
</script>

<!-- 
1. 단순 submit ~ action

파일 업로드 / 다운로드
: cos-2020.4.jar 
: 반드시 POST 방식이어야 한다
: enctype="multipart/form-data"를 기입
: <input type="file" >으로 설정해야한다
: Eclipse에서는 가상폴더, 실제폴더가 따로 있다
: <form name="" method="post" enctype="multipart/form-data" action="">으로 설정해야한다

-------------------
2. AJax 통신

processData
 - 기본값은 true
 - 기본적으로 Query String으로 변환해서 보내진다('변수=값&변수=값')
 - 파일 전송시에는 반드시 false로 해야 한다.(formData를 문자열로 변환하지 않는다)
 
contentType
  - 기본적으로 "application/x-www-form-urlencoded; charset=UTF-8"
  - 파일 전송시에는 'multipart/form-data'로 전송이 될 수 있도록 false로 설정한다

 -->