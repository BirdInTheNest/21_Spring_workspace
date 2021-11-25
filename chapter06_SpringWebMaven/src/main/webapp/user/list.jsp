<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="pg" value="${pg }">

<img alt="고심" src="/chapter06_SpringWebMaven/image/gosim05.jpg" width="70" height="70" 
style="cursor: pointer;" onclick="location.href='/chapter06_SpringWebMaven/index.jsp'">

<table id="table" border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th width="100">이름</th>
		<th width="100">아이디</th>
		<th width="100">비밀번호</th>	
	</tr>
</table>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/chapter06_SpringWebMaven/js/list.js"></script>
</body>
</html>