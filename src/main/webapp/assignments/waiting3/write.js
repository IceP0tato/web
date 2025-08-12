const addWaiting = async () => {
    const phone = document.querySelector("#phone").value;
    const count = document.querySelector("#count").value;
    const obj = {"phone": phone, "count": count};
    
    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch("/list", option);
    const data = await response.json();

    if (data) {
        alert('등록 성공');
        location.href = "/assignments/waiting3/list.jsp";
    } else {
        alert('등록 실패');
    }
}