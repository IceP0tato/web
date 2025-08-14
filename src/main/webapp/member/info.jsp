<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <link href="/css/member/info.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <h3>마이페이지</h3>
    <div id="container">
        <div>회원번호 : <span class="mno"></span></div>
        <div>아이디 : <span class="mid"></span></div>
        <div>이름 : <span class="mname"></span></div>
        <div>연락처 : <span class="mphone"></span></div>
        <div>가입일 : <span class="mdate"></span></div>
        <a href="/member/update.jsp">회원정보 수정</a>
        <a href="/member/pwdUpdate.jsp">비밀번호 수정</a>
        <a href="#" onclick="onDelete()">회원 탈퇴</a>
    </div>

    <script src="/js/member/info.js"></script>
</body>
</html>