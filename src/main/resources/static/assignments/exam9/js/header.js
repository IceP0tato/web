const _init = async () => {
    const logMenu = document.querySelector("#log-menu");
    let html = '';
    try {
        const response = await fetch("/info");
        const data = await response.json();
        html += `<li><span>${data.mid}</span></li>
        <li><a href="/assignments/exam9/info.jsp">마이페이지</a></li>
        <li><a href="#" onclick="logout()">로그아웃</a></li>`
    } catch {
        html += `<li><a href="/assignments/exam9/login.jsp">로그인</a></li>
            <li><a href="/assignments/exam9/signup.jsp">회원가입</a></li>`
    }
    logMenu.innerHTML = html;
}
_init();

const logout = async () => {
    try {
        await fetch("/logout");

        alert('로그아웃하였습니다.');
        location.href="/assignments/exam9/index.jsp";
    } catch (error) {
        console.log(error);
    }
}