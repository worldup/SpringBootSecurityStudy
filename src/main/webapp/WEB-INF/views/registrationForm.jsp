<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입 페이지</title>
</head>
<body>
<h1>회원가입 폼</h1>

<form method="post" action="/register">
	아이디: <input type="text" name="email" /><br>
	비밀번호: <input type="password" name="password" /><br>
	닉네임: <input type="text" name="nickName" /><br>
	<input type="submit" value="가입">
	<sec:csrfInput/>
</form>
</body>
</html>