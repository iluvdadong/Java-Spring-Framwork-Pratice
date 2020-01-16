<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>게시물 목록</title>
</head>
<body>
<%
	session.getAttribute("login");
%>

	${sessionScope.login}

	<c:if test="${sessionScope.login != null}">
    ${sessionScope.login.userId}<br>
		<a href="/users/logout">로그아웃</a> --%>

		<c:forEach var="board" items="${list}" varStatus="status">
			<div class="boardInfo">
				<div>${board.id}</div>
				<div>${board.userName}</div>
				<div>${board.title}</div>
				<div>${board.content}</div>
				<div>
					<fmt:formatDate value="${board.writeDate}" pattern="yyyy.MM.dd" />
				</div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${sessionScope.login == null}">
		<a href="/users/loginform">로그인</a>
	</c:if>


</body>
</html>
