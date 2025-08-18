<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="container">
        <h3>사업자 상태 조회</h3>
        <input type="text" class="b_no" placeholder="사업자 번호 입력 (- 없이)" />
        <button type="button" onclick="dataAPI2()">확인</button>

        <h3>인천 부평구 주유소 현황 API</h3>
        <table>
            <thead>
                <tr>
                    <td>연번</td>
                    <td>상호</td>
                    <td>업종</td>
                    <td>전화번호</td>
                    <td>주소</td>
                </tr>
            </thead>
            <tbody id="dataTbody">

            </tbody>
        </table>
    </div>

    <script src="/js/datago/data.js"></script>
</body>
</html>