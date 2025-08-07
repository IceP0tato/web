<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/assignments/waiting2/header.jsp"></jsp:include>
    <div>
        <h3>대기 번호 조회</h3>
        <table border="1">
            <thead>
                <tr><th>대기번호</th> <th>연락처</th> <th>인원수</th> <th>등록일</th></tr>
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
    </div>

    <script src="print.js"></script>
</body>
</html>