<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    <jsp:include page="/example/header.jsp"></jsp:include>

    <h3> Main Page : https://localhost:8080/example/home.jsp</h3>
    <h3> 홈 파일 .jsp</h3>
    
    <a href="/example/board.jsp">게시판으로</a>

    <jsp:include page="/example/footer.jsp"></jsp:include>
</body>
</html>