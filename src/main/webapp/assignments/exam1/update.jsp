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
        <h2>홈쇼핑 회원 정보 수정</h2>
        <div id="content">
            <table border="1">
                <tr>
                    <th>회원번호</th>
                    <td><input type="number" id="custNo" /></td>
                </tr>
                <tr>
                    <th>회원성명</th>
                    <td><input type="text" id="custName" /></td>
                </tr>
                <tr>
                    <th>회원전화</th>
                    <td><input type="text" id="phone" /></td>
                </tr>
                <tr>
                    <th>회원주소</th>
                    <td><input type="text" id="address" /></td>
                </tr>
                <tr>
                    <th>가입일자</th>
                    <td><input type="text" id="joinDate" /></td>
                </tr>
                <tr>
                    <th>고객등급 (A:VIP,B:일반,C:직원)</th>
                    <td><input type="text" id="grade" /></td>
                </tr>
                <tr>
                    <th>도시코드</th>
                    <td><input type="number" id="city" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="button" onclick="putMember()">수 정</button>
                        <button type="button" onclick="getMemberView()">조 회</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <jsp:include page="/assignments/exam1/footer.jsp"></jsp:include>

    <script src="/assignments/exam1/update.js"></script>
</body>
</html>