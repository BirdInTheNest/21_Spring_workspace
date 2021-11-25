<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정할 아이디 입력 : <input type="text" id="searchId">
<input type="button" id="searchBtn" value="검색">
<br><br>
<div id="resultDiv"></div>
<br><br>

<div id="modifyFormDiv">
	<form id="modifyForm">
		<table cellspacing="0" cellpadding="5">
			<tr>
				<td width="100" align="center">이름</td>
				<td>
					<input type="text" name="name" id="name" placeholder="이름 입력">
					<div id= "nameDiv"></div>
				</td>	
			</tr>
			
			<tr>
				<td width="100" align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id" readonly placeholder="아이디 입력">
				</td>	
			</tr>
			
			<tr>
				<td width="100" align="center">비밀번호</td>
				<td>
					<input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력">
					<div id= "pwdDiv"></div>
				</td>	
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="button" id="modifyBtn" value="회원정보수정">
					<input type="reset" id="resetBtn" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#modifyFormDiv').hide();
	
	$('#searchBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			url: '/chapter06_SpringWebMaven/user/getUser',
			type: 'post',
			data: {'searchId' : $('#searchId').val()},
			//dataType: 'json', 
			//서버에서 받아올 데이터는 TEXT, HTML, XML, JSON 형식을 지정할 수 있다
			//생략하면 요청한 자료에 맞게 자동으로 형식이 설정된다
			success: function(data){
				//alert(JSON.stringify(data));
				console.log(JSON.stringify(data));
				
				if(data == ''){
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
					$('#resultDiv').css('color', 'red');
					$('#resultDiv').css('font-weight', 'bold');
					
				}else{
					$('#modifyFormDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd);
				}
			},
			error: function(err){
				console.log(err);
			}
		});
	});
	
	//다시작성 버튼, readonly 걸었던 것도 다 지워지므로, DB에 다시 다녀오는 작업을 한번 더 해야함
	$('#resetBtn').click(function(){
		//반복되는 코드를 또 쓰는 것이 아니라 trigger() 함수 이용하여 강제로 이벤트 호출
		$('#searchBtn').trigger('click');
	});
	
	//회원정보수정 버튼
	$('#modifyBtn').click(function(){
		$.ajax({
			url: '/chapter06_SpringWebMaven/user/modify',
			type: 'post',
			data: $('#modifyForm').serialize(),
			success: function(){
				alert('회원 정보 수정 완료');
				location.href='/chapter06_SpringWebMaven/user/list';
			},
			error: function(err){
				console.log(err);
			}
		});
	});
});
</script>
</body>
</html>