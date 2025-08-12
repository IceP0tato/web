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
        <h2>회원목록조회/수정</h2>
        <div id="content">
            <table border="1">
                <thead>
                    <tr>
                        <th>회원번호</th>
                        <th>회원성명</th>
                        <th>전화번호</th>
                        <th>주소</th>
                        <th>가입일자</th>
                        <th>고객등급</th>
                        <th>거주지역</th>
                    </tr>
                </thead>
                <tbody id="tbody">

                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="/assignments/exam1/footer.jsp"></jsp:include>

    <script src="/assignments/exam1/members.js"></script>
</body>
</html>