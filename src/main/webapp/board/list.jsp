<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/board/header.jsp"></jsp:include>
    <div>
        <h3>게시물 전체 조회 페이지</h3>
        <a href="/board/write.jsp">글쓰기</a>
        <table border="1">
            <thead>
                <tr><th>번호</th><th>내용</th><th>작성자</th></tr>
            </thead>
            <tbody id="boardTbody">
                
            </tbody>
        </table>
    </div>

    <script src="/board/list.js"></script>
</body>
</html>