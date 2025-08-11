const boardFind = async () => {
    // queryString 값 가져오기
    const url = new URLSearchParams(location.search);
    const bno = url.get('bno');
    
    const response = await fetch(`/board/find?bno=${bno}`);
    const data = await response.json();

    const bwriterBox = document.querySelector(".bwriterBox");
    const bcontentBox = document.querySelector(".bcontentBox");
    const bwriter = data.bwriter;
    const bcontent = data.bcontent;

    bwriterBox.innerHTML = bwriter;
    bcontentBox.innerHTML = bcontent;
}
boardFind();

const boardDelete = async () => {
    const bno = new URLSearchParams(location.search).get('bno');
    let check = confirm("정말 삭제하시겠습니까?");
    if (check) {
        const option = { method : "DELETE" };
        const response = await fetch(`/board?bno=${bno}`, option);
        const data = await response.json();

        if (data) {
            alert('삭제 성공');
            location.href="/board/list.jsp";
        } else {
            alert('삭제 실패 (관리자에게 문의)');
        }
    }
}

const boardUpdateView = () => {
    const bno = new URLSearchParams(location.search).get('bno');
    location.href=`/board/update.jsp?bno=${bno}`;
}