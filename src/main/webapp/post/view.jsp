<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div class="container">
        <div>
            <div>작성자 : <span class="mid"></span></div>
            <div>
                조회수 : <span class="pview"></span>
                작성일 : <span class="pdate"></span>
            </div>
            <div class="ptitle">

            </div>
            <div class="pcontent">

            </div>
        </div>
        <div class="etcBox">
            <!-- 본인이 작성한 글일 시 수정/삭제 버튼 추가 -->
        </div>

        <!-- 댓글 등록 구역 -->
        <div> 
            <textarea class="rcontent"></textarea>
            <button onclick="writeReply()">댓글 등록</button>
        </div>

        <!-- 댓글 조회 구역 -->
        <div class="replyList">

        </div>
    </div>

    <script src="/js/post/view.js"></script>
</body>
</html>