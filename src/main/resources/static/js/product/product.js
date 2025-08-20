let latlng = null;

const getMap = () => {
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.4905335508, 126.7244907601), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도를 클릭한 위치에 표출할 마커입니다
    var marker = new kakao.maps.Marker({ 
        // 지도 중심좌표에 마커를 생성합니다 
        position: map.getCenter() 
    }); 
    // 지도에 마커를 표시합니다
    marker.setMap(map);

    // 지도에 클릭 이벤트를 등록합니다
    // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
        
        // 클릭한 위도, 경도 정보를 가져옵니다 (전역 변수로 전환)
        latlng = mouseEvent.latLng; 

        // 마커 위치를 클릭한 위치로 옮깁니다
        marker.setPosition(latlng);
        
        var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
        message += '경도는 ' + latlng.getLng() + ' 입니다';
        
        var resultDiv = document.getElementById('clickLatlng'); 
        resultDiv.innerHTML = message;
        
    });
}
getMap();

const onCreate = async () => {
    // form 전체를 가져오는 방법 (속성명은 name으로 자바의 dto와 일치해야 함)

    // 전송할 폼 가져오기
    const productForm = document.querySelector("#productForm");
    // 대용량 첨부파일 폼 전환
    const productFormData = new FormData(productForm);
    // 위도, 경도는 JS에서 표현한 것으로 직접 폼에 넣기 (.append("속성명", 값))
    productFormData.append('plat', latlng.getLat()); // 위도
    productFormData.append('plng', latlng.getLng()); // 경도

    // 헤더 생략 가능 (자동 세팅)
    const option = {
        method : "POST",
        body : productFormData
    };
    const response = await fetch('/product/create', option);
    const data = await response.json();
    
    if (data > 0) {
        alert('등록 성공');
    } else {
        alert('등록 실패');
    }
}