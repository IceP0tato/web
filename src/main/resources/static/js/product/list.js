let productList = [];

const getList = async () => {
    const response = await fetch("/product/list");
    const data = await response.json();
    console.log(data);

    // 전역변수로 제품 정보 저장
    productList = data;
}

const getMap = async () => {
    // 현재 사용자의 위치 좌표 가져오기
    const position = await myPosition();

    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.4905335508, 126.7244907601), // 지도의 중심좌표
        level : 8 // 지도의 확대 레벨
    });

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // 1. map 반복문을 이용한 전역변수의 제품리스트 반복
    /* let markerList = [];
    for (let i=0; i<productList.length; i++) {
        const product = productList[i];
        // 카카오 API의 마커 객체 생성 (현재 제품의 위도와 경도를 마커에 대입)
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng(product.plat, product.plng)
        });
        // 마커들을 저장하는 마커 리스트에 push
        markerList.push(marker);
    } */
    // 반복문 종료 후 마커들을 클러스터에 넣기
    /* clusterer.addMarkers(markerList); */

    // 2. 전역변수에 있는 제품리스트를 마커로 생성
    let markers = productList.map((product) => {
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng(product.plat, product.plng)
        });
        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'click', () => {
            alert(`클릭한 제품명 : ${product.pname}`);
        });
        return marker;
    })
    // 반복문 종료 후 마커들을 클러스터에 넣기
    clusterer.addMarkers(markers);

    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
}

// 함수 동기화
const _init = async () => {
    await getList(); // 카카오맵이 실행되기 전에 제품 정보 가져오기 우선 실행
    await getMap();
}
_init();