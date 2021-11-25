<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>${param.x } + ${param.y } + ${param.x + param.y }</h1> --%><!-- request.getParameter("x") 자바일 때 -->

<%-- <h1>${x } + ${y } = ${x + y }</h1> --%>

<!-- JSTL에서는 메소드명을 변수명처럼 사용할 수 있으므로, sumDTO.getX() => sumDTO.x -->
<h1>${sumDTO.x } + ${sumDTO.y } = ${sumDTO.x + sumDTO.y }</h1>
</body>
</html>