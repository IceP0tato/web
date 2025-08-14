const signUp = async () => {
    // 유효성 검사 체크 (.includes 는 boolean 반환)
    if (signPass.includes(false)) {
        alert('올바른 정보를 입력 후 가능합니다.');
        return;
    }

    const idInput = document.querySelector('#idInput');
    const pwdInput = document.querySelector('#pwdInput');
    const nameInput = document.querySelector('#nameInput');
    const phoneInput = document.querySelector('#phoneInput');
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;
    const obj = {mid, mpwd, mname, mphone};

    try {
        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(obj)
        }
        const response = await fetch('/member/signup', option);
        const data = await response.json();

        if (data > 0) {
            alert('회원가입 성공');
            location.href = '/member/login.jsp';
        } else {
            alert('회원가입 실패');
        }
    } catch (error) { console.log(error); }
}

// 유효성 검사 체크리스트
const signPass = [false, false]; // 초기값은 실패, 0: 아이디 체크, 1: 연락처 체크

const idCheck = async () => {
    const mid = document.querySelector('#idInput').value;
    const idCheck = document.querySelector('.idCheck');

    // 길이 검사
    if (mid.length < 6) {
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다.";
        signPass[0] = false;
        return;
    }

    // 중복 검사
    try {
        const response = await fetch(`/member/check?type=mid&data=${mid}`);
        const data = await response.json();

        if (data) {
            idCheck.innerHTML = "사용중인 아이디입니다.";
            signPass[0] = false;
            return;
        } else {
            idCheck.innerHTML = "사용가능한 아이디입니다.";
            signPass[0] = true;
        }
    } catch (error) { console.log(error); }
}

const phoneCheck = async () => {
    const mphone = document.querySelector('#phoneInput').value;
    const phoneCheck = document.querySelector('.phoneCheck');

    // 길이 검사
    if (mphone.length != 13) {
        phoneCheck.innerHTML = "-(하이픈) 포함 13글자 연락처를 입력해주세요.";
        signPass[1] = false;
        return;
    }

    // 중복 검사
    try {
        const response = await fetch(`/member/check?type=mphone&data=${mphone}`);
        const data = await response.json();

        if (data) {
            phoneCheck.innerHTML = "사용중인 전화번호입니다.";
            signPass[1] = false;
            return;
        } else {
            phoneCheck.innerHTML = "사용가능한 전화번호입니다.";
            signPass[1] = true;
        }
    } catch (error) { console.log(error); }
}