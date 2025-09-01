// 현재 페이지의 URL에서 매개변수 값 반환
const params = new URL(location.href).searchParams;
// 사용자가 요청한 URL에서 카테고리, 현재 페이지 번호 등 가져오기
const cno = params.get('cno');
const page = params.get('page') || 1; // page가 존재하지 않으면 1
const key = params.get('key') || ''; // key가 존재하지 않으면 ''
const keyword = params.get('keyword') || '';

// 요청 매개변수를 이용하여 fetch 게시물 요청
const findAll = async () => {
    try {
        const url = `/post?cno=${cno}&page=${page}&key=${key}&keyword=${keyword}`;
        const response = await fetch(url);
        const data = await response.json();

        const postBody = document.querySelector(".postBody");
        let html = '';
        data.data.forEach((post) => {
            html += `<tr>
                        <td>${post.pno}</td>
                        <td>${post.ptitle}</td>
                        <td>${post.mid}</td>
                        <td>${post.pdate}</td>
                        <td>${post.pview}</td>
                    </tr>`;
        })
        viewPageButtons(data);
    } catch (e) {
        console.log(e);
    }
}

// 페이징 버튼 출력 함수 (findAll 함수 하단에서 실행)
const viewPageButtons = async (data) => {
    let currentPage = parseInt(data.currentPage);
    let totalPage = data.totalpage;
    let startBtn = data.startBtn;
    let endBtn = data.endBtn;

    // 페이징 처리 시 검색 유지
    const searchURL = `&key=${key}&keyword=${keyword}`;
    const pageBtnBox = document.querySelector(".pageBtnBox");
    let html = '';

    // 이전 버튼 : 현재 페이지가 1 이하면 1 고정
    html += `<li><a href="post.jsp?cno=${cno}&page=${currentPage<=1?1:currentPage-1}${searchURL}">이전</a></li>`;
    // 페이지 버튼 : startBtn부터 endBtn까지 1씩 증가
    for (let i=startBtn; i<=endBtn; i++) {
        html += `<li><a href="post.jsp?cno=${cno}&page=${i}${searchURL}" style="${i==currentPage?'color:red;':''}">${i}</a></li>`;
    }
    
    // 다음 버튼 : 다음 페이지가 전체 페이지 수 이상이면 전체 페이지 수로 고정
    html += `<li><a href="post.jsp?cno=${cno}&page=${currentPage+1>=totalPage?totalPage:currentPage+1}${searchURL}">다음</a></li>`;
    
    pageBtnBox.innerHTML = html;
}

// 검색 버튼
const onSearch = async () => {
    const newKey = document.querySelector(".key").value;
    const newKeyword = document.querySelector(".keyword").value;

    // 페이지 이동
    location.href = `/post.jsp?cno=${cno}&page=${1}&key=${newKey}&keyword=${newKeyword}`;
}

findAll();