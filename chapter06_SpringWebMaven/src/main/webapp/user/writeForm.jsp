<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#writeForm div{
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form id="writeForm">

<img alt="고심" src="/chapter06_SpringWebMaven/image/gosim02.jpg" width="70" height="70" 
style="cursor: pointer;" onclick="location.href='/chapter06_SpringWebMaven/index.jsp'">

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
			<input type="text" name="id" id="id" placeholder="아이디 입력">
			<div id= "idDiv"></div>
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
		<td width="100" align="center">재확인</td>
		<td>
			<input type="password" name="repwd" id="repwd" placeholder="비밀번호 입력">
			<div id= "repwdDiv"></div>
		</td>	
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="button" id="writeBtn" value="회원가입">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/chapter06_SpringWebMaven/js/user.js"></script>
</body>
</html>