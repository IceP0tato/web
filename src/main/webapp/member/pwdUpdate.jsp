<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <link href="/css/member/pwdUpdate.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <h3>비밀번호 수정 페이지</h3>
        <div>기존 패스워드 : <input class="oldPwd" /></div>
        <div>새로운 패스워드 : <input class="newPwd" /></div>
        <button type="button" onclick="onPwdUpdate()">수정</button>
    </div>

    <script src="/js/member/pwdUpdate.js"></script>
</body>
</html>