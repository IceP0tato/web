const findId = async () => {
    const mname = document.querySelector('#mname_id').value;
    const mphone = document.querySelector('#mphone_id').value;
    const idBox = document.querySelector('#idBox');

    try {
        const response = await fetch(`/member/find/id?mname=${mname}&mphone=${mphone}`);
        const data = await response.json();

        if (data.mid == null) {
            idBox.innerHTML = '회원정보 없음';
        } else {
            idBox.innerHTML = `당신의 아이디는 '${data.mid}'입니다.`;
        }
    } catch (error) { console.log(error); }
}

const findPwd = async () => {
    const mid = document.querySelector('#mid_pwd').value;
    const mphone = document.querySelector('#mphone_pwd').value;
    const pwdBox = document.querySelector('#pwdBox');
    const obj = {mid, mphone};

    try {
        const option = {
            method : "PUT",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/member/find/pwd', option);
        const data = await response.json();

        if (data.mpwd == null) {
            pwdBox.innerHTML = '회원정보 없음';
        } else {
            pwdBox.innerHTML = `임시 비밀번호는 '${data.mpwd}'입니다. 반드시 비밀번호를 변경해주세요.`;
        }
    } catch (error) { console.log(error); }
}