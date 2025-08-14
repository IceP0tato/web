const onInfo = async () => {
    const mno = document.querySelector('.mno');
    const mid = document.querySelector('.mid');
    const mname = document.querySelector('.mname');
    const mphone = document.querySelector('.mphone');
    const mdate = document.querySelector('.mdate');

    try {
        const option = { method : "GET" };
        const response = await fetch('/member/info', option);
        const data = await response.json();

        mno.innerHTML = data.mno;
        mid.innerHTML = data.mid;
        mname.innerHTML = data.mname;
        mphone.innerHTML = data.mphone;
        mdate.innerHTML = data.mdate;
    } catch (error) {
        console.log(error);
        location.href = "/member/login.jsp";
    }
}
onInfo();

const onDelete = async () => {
    let result = confirm('정말 탈퇴하시겠습니까?');
    if (confirm == false) {
        return;
    }
    let oldPwd = prompt('현재 비밀번호 입력');

    try {
        const option = { method : "DELETE" };
        const response = await fetch(`/member/delete?oldPwd=${oldPwd}`, option);
        const data = await response.json();

        if (data) {
            alert('탈퇴 성공');
            location.href = "/index.jsp";
        } else {
            alert('탈퇴 실패 : 기존 패스워드가 일치하지 않습니다.');
        }
    } catch (error) { console.log(error); }
}
