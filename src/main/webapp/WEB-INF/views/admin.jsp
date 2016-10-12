<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>어드민 입니다.</h1>
	<br>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.nickName" /> 님 안녕하세요, 당신은 어드민 유저 입니다. <br>
	</sec:authorize>


	<br>
	<a href="/users">user</a>
	<br>
	<br>
	<a href="/registerform">회원가입</a>
	<br>
</body>
</html>