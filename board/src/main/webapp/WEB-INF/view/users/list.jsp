<%@page import="examples.springmvc.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 목록</title>
	<link rel="stylesheet" href="/resources/css/board_list.css">
</head>
<body>
	<c:if test="${sessionScope.login != null}">
	${sessionScope.login.userId } 님 환영합니다. <a href="/users/logout">로그아웃</a>
	<h1>회원목록</h1>
	<div class="userList">
		<div class="userListHead">
			<div>id</div>
			<div>이름</div>
			<div>가입일</div>
		</div>
		<c:forEach var="user" items="${list}" varStatus="status">
			<div class="userInfo">
				<div>${user.userId}</div>
				<div>${user.name}</div>
				<div>
					<fmt:formatDate value="${user.joinDate}" pattern="yyyy.MM.dd" />
				</div>
			</div>
		</c:forEach>
		</div>	
		</c:if>
		<c:if test="${sessionScope.login == null }">
			<a href="/users/loginform">로그인</a>
		</c:if>
</body>
</html>