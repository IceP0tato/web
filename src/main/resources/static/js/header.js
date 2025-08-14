const myinfo = async () => {
    const logMenu = document.querySelector("#log-menu");
    let html = '';
    try {
        const response = await fetch("/member/info");
        const data = await response.json();
        // 정상 통신 (로그인)
        // 비로그인 시 응답 자료가 null이라서 .json() 타입 변환 시 오류 발생 -> catch로 이동
        html += `<li><span>${data.mid}님 </span></li>
            <li><a href="/member/info.jsp">내정보</a></li>
            <li><a href="#" onclick="logout()">로그아웃</a></li>`
    } catch {
        // 비정상 통신 (비로그인)
        html += `<li><a href="/member/login.jsp">로그인</a></li>
            <li><a href="/member/signup.jsp">회원가입</a></li>`
    }
    logMenu.innerHTML = html;
}
myinfo();

const logout = async () => {
    try {
        const response = await fetch("/member/logout");
        const data = await response.json();

        if (data) {
            alert('로그아웃하였습니다.');
            location.href="/index.jsp";
        } else {
            alert('비정상적인 요청입니다.');
        }
    } catch (error) {
        console.log(error);
    }
}