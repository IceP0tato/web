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
        <div id="map" style="width:500px;height:400px;"></div>

        <div id="map2" style="width:500px;height:400px;"></div>
        <p><em>지도를 클릭해주세요!</em></p> 
        <div id="clickLatlng"></div>

        <div id="map3" style="width:100%;height:350px;"></div>
        <p><em>마커를 클릭해주세요!</em></p>

        <div id="map4" style="width:100%;height:350px;"></div>
    </div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd"></script>
    <script src="/js/kakao/map.js"></script>
</body>
</html>