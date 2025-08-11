<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/board/header.jsp"></jsp:include>
    <div>
        <h3>게시물 수정 페이지</h3>
        내용 : <textarea class="bcontent"></textarea> <br />
        <button type="button" onclick="boardUpdate()">수정</button>
    </div>

    <script src="/board/update.js"></script>
</body>
</html>