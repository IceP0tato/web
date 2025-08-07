const add = async () => {
    const phoneInput = document.querySelector("#phone");
    const countInput = document.querySelector("#count");
    const phone = phoneInput.value;
    const count = countInput.value;
    const object = { phone : phone, count : count };

    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(object)
    };
    const response = await fetch("/waiting/post", option);
    const data = await response.json();

    if (data) {
        alert('등록 성공');
        location.href = "/assignments/waiting2/print.jsp";
    } else {
        alert('등록 실패');
    }
}