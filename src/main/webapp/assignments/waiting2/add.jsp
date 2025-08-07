<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/waiting2/header.jsp"></jsp:include>
    <div>
        <h3>대기 번호 등록</h3>
        연락처 : <input type="text" id="phone" /> <br />
        인원수 : <input type="number" id="count" /> <br />
        <button type="button" onclick="add()">등록</button>
    </div>

    <script src="add.js"></script>
</body>
</html>