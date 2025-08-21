<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/exam9/header.jsp"></jsp:include>
    <h3>마이페이지</h3>
    <div id="img"></div>
    <hr />
    <form>
        <input type="file" accept="image/*" name="mimg" />
        <button type="button" onclick="change()">이미지 수정</button>
    </form>

    <script src="/assignments/exam9/js/info.js"></script>
</body>
</html>