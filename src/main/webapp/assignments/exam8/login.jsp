<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/exam8/header.jsp"></jsp:include>
    <h3>로그인</h3>
    ID : <input id="mid" /> <br />
    PW : <input id="mpwd" /> <br />
    <button type="button" onclick="login()">Login</button>

    <script src="/assignments/exam8/js/login.js"></script>
</body>
</html>