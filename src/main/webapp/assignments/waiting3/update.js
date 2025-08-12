const showWaiting = async () => {
    const num = new URLSearchParams(location.search).get('num');
    const phoneDiv = document.querySelector("#phone");
    const countDiv = document.querySelector("#count");

    const response = await fetch(`/list/find?num=${num}`);
    const data = await response.json();
    const phoneData = data.phone;
    const countData = data.count;

    phoneDiv.value = phoneData;
    countDiv.value = countData;
}
showWaiting();

const updateWaiting = async () => {
    const num = new URLSearchParams(location.search).get('num');
    const phone = document.querySelector("#phone").value;
    const count = document.querySelector("#count").value;
    const obj = {"num": num, "phone": phone, "count": count};
    
    const option = {
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch(`/list`, option);
    const data = await response.json();

    if (data) {
        alert('등록 성공');
        location.href = `/assignments/waiting3/list.jsp?num=${num}`;
    } else {
        alert('등록 실패');
    }
}