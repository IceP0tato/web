const login = async () => {
    const mid = document.querySelector("#mid").value;
    const mpwd = document.querySelector("#mpwd").value;
    const obj = {mid, mpwd};
    
    try {
        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/login', option);
        const data = await response.json();

        if (data > 0) {
            alert('로그인 성공');
            location.href = "/assignments/exam9/index.jsp";
        } else {
            alert('로그인 실패');
        }
    } catch (error) {
        console.log(error);
    }
}