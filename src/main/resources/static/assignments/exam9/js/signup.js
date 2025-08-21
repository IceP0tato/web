const signup = async () => {
    const mid = document.querySelector("#mid").value;
    const mpwd = document.querySelector("#mpwd").value;
    const mimg = document.querySelector("#mimg").value;
    const obj = {mid, mpwd, mimg};
    console.log(obj);

    try {
        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/signup', option);
        const data = await response.json();

        if (data > 0) {
            alert('회원가입 성공');
            location.href = '/assignments/exam9/login.jsp';
        } else {
            alert('회원가입 실패');
        }
    } catch (error) { 
        console.log(error);
    }
}