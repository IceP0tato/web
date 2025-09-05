// [*] 썸머노트 실행
// $ : jquery( JS확장 라이브러리) 문법 , 
$(document).ready(function() {
    $('#summernote').summernote({
        lang: 'ko-KR' ,  // 썸머노트 메뉴들을 한글화 속성 
        minHeight : 300 , // 썸머노트 구역 최소높이
    });
});

const params = new URL(location.href).searchParams;
const pno = params.get('pno');

const getPost = async () => {
    const response = await fetch(`/post/view?pno=${pno}`);
    const data = await response.json();

    document.querySelector('.cno').value = data.cno;
    document.querySelector('.ptitle').value = data.ptitle;
    document.querySelector('.note-editable').innerHTML = data.pcontent;
}
getPost();

const updatePost = async () => {
    const cno = document.querySelector('.cno').value;
    const ptitle = document.querySelector('.ptitle').value;
    const pcontent = document.querySelector('.pcontent').value;
    const obj = {cno, ptitle, pcontent, pno};

    const option = {
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch('/post', option);
    const data = await response.json();

    if (data == 0) {
        alert('수정 실패');
    } else {
        alert('수정 성공');
        location.href = `view.jsp?pno=${pno}`;
    }
}