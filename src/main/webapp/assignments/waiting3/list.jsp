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
        <table border="1">
            <thead>
                <tr><th>대기번호</th><th>연락처</th><th>인원수</th><th>등록일시</th></tr>
            </thead>
            <tbody id="list">

            </tbody>
        </table>
        <a href="/assignments/waiting3/write.jsp">대기 등록</a>
    </div>

    <script src="/assignments/waiting3/list.js"></script>
</body>
</html>