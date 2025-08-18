const dataAPI1 = async () => {
    const serviceKey = "nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D";
    const URL = "https://api.odcloud.kr/api/15102672/v1/uddi:d26dabc4-e094-463d-a4b1-cab3af66bb6d?page=1&perPage=38&serviceKey="
    
    const option = { method : "GET" };
    const response = await fetch(URL+serviceKey, option);
    const data = await response.json();
    console.log(data);
    console.log(data.data);

    const dataTbody = document.querySelector('#dataTbody');
    let html = '';

    // forEach : 리스트 내 요소를 하나씩 변수(value)에 반복 대입
    data.data.forEach((value) => {
        html += `<tr>
                    <td>${value.연번}</td>
                    <td>${value.상호}</td>
                    <td>${value.업종}</td>
                    <td>${value.전화번호}</td>
                    <td>${value['주소']}</td>
                </tr>`;
    })
    dataTbody.innerHTML = html;
}
dataAPI1();

const dataAPI2 = async () => {
    const b_no = document.querySelector('.b_no').value;
    var obj = { // 중복 가능한 변수 타입 (과거에 사용했고, 최근에는 let 이 사용됨)
        "b_no" : [b_no]
    };

    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    };
    const serviceKey = "nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D";
    const URL = "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=";
    const response = await fetch(URL+serviceKey, option);
    const data = await response.json();
    console.log(data);
    alert(data.data[0]["tax_type"]); // 속성명에 특수문자가 포함된 경우 접근연산자(.) 불가능
}