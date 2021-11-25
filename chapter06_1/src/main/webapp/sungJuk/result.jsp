<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th colspan="2">${sungJukDTO.name } 성적</th>
		</tr>
		<tr>
			<td>총점 : </td>
			<td>${sungJukDTO.tot }</td>
		</tr>
		<tr>
			<td>평균 : </td>
			<td>${sungJukDTO.avg }</td>
		</tr>
	</table>
</body>
</html>