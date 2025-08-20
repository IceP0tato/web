<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/exam8/header.jsp"></jsp:include>
    <h3>회원가입</h3>
    ID : <input id="mid" /> <br />
    PW : <input id="mpwd" /> <br />
    <div>(안내 : 회원가입 시 1000 포인트가 기본 지급됩니다.)</div>
    <button type="button" onclick="signup()">Sign Up</button>

    <script src="/assignments/exam8/js/signup.js"></script>
</body>
</html>