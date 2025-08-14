const onPwdUpdate = async () => {
    const oldPwd = document.querySelector('.oldPwd').value;
    const newPwd = document.querySelector('.newPwd').value;
    const obj = {oldPwd, newPwd};

    try {
        const option = {
            method : "PUT",
            headers : {"Content-Type": "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch("/member/update/password", option);
        const data = await response.json();

        if (data) {
            alert('수정 성공');
            location.href = "/member/info.jsp";
        } else {
            alert('수정 실패');
        }
    } catch (error) { console.log(error); }
}