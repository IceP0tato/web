const waitingInsert = ( ) => {
    console.log("전화번호 : 010-1234-1234, 인원수 : 4로 새로운 데이터를 삽입합니다.");
    let data = { "phone" : "010-1234-1234", "count" : 4 };
    let option = {
        method : "POST",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(data)
    };
    fetch("/list", option)
        .then( response => response.json() )
        .then( data => { console.log(data) })
        .catch( error => { console.log(error) });
}

const waitingSelect = ( ) => {
    console.log("모든 레코드를 가져옵니다.");
    let option = { method : "GET" };
    fetch("/list", option)
        .then( response => response.json() )
        .then( data => { console.log(data) })
        .catch( error => { console.log(error) });
}

const waitingDelete = ( ) => {
    console.log("번호가 10인 데이터를 삭제합니다.");
    let num = 10;
    let option = { method : "DELETE" };
    fetch(`/list?num=${num}`, option)
        .then( response => response.json() )
        .then( data => { console.log(data) })
        .catch( error => { console.log(error) });
}

const waitingUpdate = ( ) => {
    console.log("번호가 1인 데이터의 인원수를 10으로 변경합니다.");
    let data = { "num" : 1, "count" : 10 };
    let option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify(data)
    };
    fetch("/list", option)
        .then( response => response.json() )
        .then( data => { console.log(data) })
        .catch( error => { console.log(error) });
}