<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>쇼핑몰 회원관리 프로그램</title>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
    <jsp:include page="/assignments/exam1/header.jsp"></jsp:include>
    <div id="wrap">
        <h2>회원매출조회</h2>
        <div id="content">
            <table border="1">
                <thead>
                    <tr>
                        <th>회원번호</th>
                        <th>회원성명</th>
                        <th>고객등급</th>
                        <th>매출</th>
                    </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="/assignments/exam1/footer.jsp"></jsp:include>

    <script src="/assignments/exam1/sales.js"></script>
</body>
</html>