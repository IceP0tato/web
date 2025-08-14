<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <link href="/css/member/find.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <h3>아이디 찾기</h3>
        <div>이름 : <input id="mname_id" /></div>
        <div>연락처 : <input id="mphone_id" /></div>
        <button onclick="findId()">찾기</button>
        <div id="idBox"></div>

        <h3>비밀번호 찾기</h3>
        <div>아이디 : <input id="mid_pwd" /></div>
        <div>연락처 : <input id="mphone_pwd" /></div>
        <button onclick="findPwd()">찾기</button>
        <div id="pwdBox"></div>
    </div>

    <script src="/js/member/find.js"></script>
</body>
</html>