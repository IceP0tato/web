const login = async () => {
    // 마크업을 DOM 객체로 가져오기
    const idInput = document.querySelector("#idInput");
    const pwdInput = document.querySelector("#pwdInput");
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const obj = {mid, mpwd};
    
    try {
        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/member/login', option);
        const data = await response.json();

        if (data > 0) {
            alert('로그인 성공');
            location.href = "/index.jsp";
        } else {
            alert('로그인 실패');
        }
    } catch {}
}