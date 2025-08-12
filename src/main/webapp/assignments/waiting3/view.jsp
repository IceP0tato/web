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
        <h3>대기 현황 페이지</h3>
        대기번호 : <div id="num"></div><br />
        연락처 : <div id="phone"></div><br />
        인원수 : <div id="count"></div><br />
        등록일시 : <div id="date"></div><br />
        <button type="button" onclick="updateWaitingView()">수정</button>
        <button type="button" onclick="deleteWaiting()">삭제</button>        
    </div>

    <script src="/assignments/waiting3/view.js"></script>
</body>
</html>