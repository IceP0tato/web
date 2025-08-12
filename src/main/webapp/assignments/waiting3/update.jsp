<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/waiting3/header.jsp"></jsp:include>
    <div>
        <h3>수정 페이지</h3>
        연락처 : <input type="text" id="phone" /><br />
        인원수 : <input type="number" id="count" /><br />
        <button type="button" onclick="updateWaiting()">수정</button>
    </div>

    <script src="/assignments/waiting3/update.js"></script>
</body>
</html>