console.log('example2.js');


// fetch(URL 주소, HEADER 정보) (.then(응답매개변수 => 응답매개변수.타입명()))
const func1 = ( ) => { 
    fetch("/d04/exam1"); // 외부 주소로부터 요청과 응답을 비동기 통신으로 지원하는 함수 (라이브러리 내장 함수)
}

const func2 = ( ) => {
    fetch("/d04/exam2", { method : "POST" });
}

const func3 = ( ) => {
    fetch("/d04/exam3", { method : "PUT" });
}

const func4 = ( ) => {
    fetch("/d04/exam4", { method : "DELETE" });
}

const func5 = ( ) => {
    console.log('func5 exe');
    const name = "유재석";
    const age = 10;
    fetch(`/d04/exam5?name=${name}&age=${age}`, { method : "GET" })
        .then(response => response.json()) // 응답 자료를 매개변수로 받아 json 타입으로 변환
        .then(data => { console.log(data); }) // 타입 변환된 자료를 매개변수로 받아 실행문 처리
        .catch(error => { console.log(error); }) // 통신 도중에 오류 발생 시 실행문 처리
}

const func6 = ( ) => {
    const name = "유재석";
    const age = 10;
    const option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" }, // HTTP BODY 타입 설정
        body : JSON.stringify({ name : name, age : age }) // JSON 타입으로 변환, JSON.stringify()
    }
    fetch(`/d04/exam6`, option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) })
}

const func7 = ( ) => {
    let sample = { name : "유재석", age : 10 };
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(sample)
    }
    fetch("/d04/exam7", option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) })
}

const func8 = ( ) => {
    let name = "유재석";
    let age = 40;
    fetch(`/d04/exam8?name=${name}&age=${age}`, { method : "DELETE" })
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) })
}