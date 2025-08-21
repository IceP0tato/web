<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/exam9/header.jsp"></jsp:include>
    <h3>회원가입</h3>
    ID : <input id="mid" /> <br />
    PW : <input id="mpwd" /> <br />
    프로필 사진 : <input type="file" accept="image/*" id="mimg" /> <br />
    <button type="button" onclick="signup()">Sign Up</button>

    <script src="/assignments/exam9/js/signup.js"></script>
</body>
</html>