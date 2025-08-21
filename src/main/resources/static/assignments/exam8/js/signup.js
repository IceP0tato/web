const signup = async () => {
    const mid = document.querySelector("#mid").value;
    const mpwd = document.querySelector("#mpwd").value;
    const obj = {mid, mpwd};

    try {
        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/exam8/signup', option);
        const data = await response.json();

        if (data > 0) {
            alert('회원가입 성공');
            location.href = '/assignments/exam8/login.jsp';
        } else {
            alert('회원가입 실패');
        }
    } catch (error) { 
        console.log(error);
    }
}