const onInfo = async () => {
    const mno = document.querySelector('.mno');
    const mid = document.querySelector('.mid');
    const mname = document.querySelector('.mname');
    const mphone = document.querySelector('.mphone');

    try {
        const response = await fetch('/member/info');
        const data = await response.json();

        mno.innerHTML = data.mno;
        mid.innerHTML = data.mid;
        mname.value = data.mname;
        mphone.value = data.mphone;
    } catch (error) {
        console.log(error);
        location.href = "/member/login.jsp";
    }
}
onInfo();

const onUpdate = async () => {
    const mname = document.querySelector('.mname').value;
    const mphone = document.querySelector('.mphone').value;
    const obj = {mname, mphone};

    try {
        const option = {
            method : "PUT",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/member/update', option);
        const data = await response.json();

        if (data) {
            alert('수정 성공');
            location.href = "/member/info.jsp";
        } else {
            alert('수정 실패');
        }
    } catch (error) { console.log(error); }
}