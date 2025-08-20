// 컴퓨터 IP 기반 위치 조회 (오차가 있을 수 있음)
const myPosition = async () => {
    // new Promise : 비동기 객체, resolve : 성공, reject : 실패
    const position = await new Promise((resolve, reject) => {
        // 현재 브라우저가 ip 기반으로 위도/경도 조회 (성공, 실패, {옵션})
        navigator.geolocation.getCurrentPosition(resolve, reject, {
            // 가능한 정확한 위치 (속도 느림, 전기 소모 큼)
            enableHighAccuracy : true,
            // 밀리초 단위 (5초 안에 가져오지 못하면 reject 반환)
            timeout : 5000,
            // 캐시(임시) 정보는 사용 안함 (항상 새로고침)
            maximumAge : 0
        });
    });
    console.log(`위치 정보 : ${position}`);
    console.log(`위도 : ${position.coords.latitude}`);
    console.log(`경도 : ${position.coords.longitude}`);

    return position;
}