console.log("exam11.js 실행");

const boardWrite = ( ) => {
    console.log("boardWrite() 실행");
    let data = { "bcontent" : "JS 테스트", "bwriter" : "유재석" };
    let option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(data)
    };
    fetch("/board", option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) });
}

const boardPrint = ( ) => {
    console.log("boardPrint() 실행");
    let option = { method : "GET" };
    fetch("/board", option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) });
}

const boardDelete = ( ) => {
    console.log("boardDelete() 실행");
    let bno = 3;
    let option = { method : "DELETE" };
    fetch(`/board?bno=${bno}`, option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) });
}

const boardUpdate = ( ) => {
    console.log("boardUpdate() 실행");
    let data = { "bno" : 2, "bcontent" : "안녕하세요." };
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(data)
    };
    fetch("/board", option)
        .then(response => response.json())
        .then(data => { console.log(data) })
        .catch(error => { console.log(error) });
}