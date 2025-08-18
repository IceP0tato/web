<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <link href="/css/kakao/datamap.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="container">
        <div id="map"></div>
        <div id="sidebar"></div>
    </div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
    <script src="/js/kakao/datamap.js"></script>
</body>
</html>