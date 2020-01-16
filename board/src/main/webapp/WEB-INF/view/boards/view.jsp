<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <title>게시물 상세보기</title>
  </head>
  <body>
    id : ${board.id} <br>
    name : ${board.userName} <br>
    user_id : ${board.userId} <br>
    title : ${board.title} <br>
    content : ${board.content} <br>
    writeDate : ${board.writeDate} <br>
  </body>
</html>
