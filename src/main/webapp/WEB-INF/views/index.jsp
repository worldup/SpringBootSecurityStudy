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
	<h1>환영합니다.</h1>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.nickName" /> 님 안녕하세요. <br>
		<sec:authorize access="hasRole('USER')"> 일반 유저 입니다. <br></sec:authorize>
		<sec:authorize access="hasRole('ADMIN')"> 관리자 입니다. <br></sec:authorize>
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="로그아웃" />
			<sec:csrfInput />
		</form>
		<br>
		<br>
	</sec:authorize>


	<a href="/admin">어드민</a>
	<br>
	<a href="/users">user</a>
	<br>
	<br>
	<sec:authorize access="isAnonymous()">
		<a href="/registrationForm">회원가입</a>
		<br>
	</sec:authorize>
	<br>
	<sec:authorize access="isRememberMe()"> 쿠키로 로그인 했습니다.</sec:authorize>
</body>
</html>