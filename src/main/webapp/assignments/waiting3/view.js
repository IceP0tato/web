const showWaiting = async () => {
    const num = new URLSearchParams(location.search).get('num');
    const numDiv = document.querySelector("#num");
    const phoneDiv = document.querySelector("#phone");
    const countDiv = document.querySelector("#count");
    const dateDiv = document.querySelector("#date");

    const response = await fetch(`/list/find?num=${num}`);
    const data = await response.json();
    console.log(data);
    const numData = data.num;
    const phoneData = data.phone;
    const countData = data.count;
    const dateData = data.date;

    numDiv.innerHTML = numData;
    phoneDiv.innerHTML = phoneData;
    countDiv.innerHTML = countData;
    dateDiv.innerHTML = dateData;
}
showWaiting();

const updateWaitingView = () => {
    const num = new URLSearchParams(location.search).get('num');
    location.href = `update.jsp?num=${num}`
}

const deleteWaiting = async () => {
    const num = new URLSearchParams(location.search).get('num');
    const option = { method : "DELETE" }
    const response = await fetch(`/list?num=${num}`, option);
    const data = response.json();

    if (data) {
        alert('삭제 성공');
        location.href = "list.jsp";
    } else {
        alert('삭제 실패');
    }
}