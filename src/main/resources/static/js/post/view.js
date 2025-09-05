const params = new URL(location.href).searchParams;
const pno = params.get('pno');

const getPost = async () => {
    const response = await fetch(`/post/view?pno=${pno}`);
    const data = await response.json();

    document.querySelector('.mid').innerHTML = data.mid;
    document.querySelector('.pview').innerHTML = data.pview;
    document.querySelector('.pdate').innerHTML = data.pdate;
    document.querySelector('.ptitle').innerHTML = data.ptitle;
    document.querySelector('.pcontent').innerHTML = data.pcontent;

    // 본인이 작성한 글일 시 수정/삭제 버튼 추가
    if (data.host) {
        document.querySelector('.etcBox').innerHTML =
        `<button type="button" onclick="deletePost()">삭제</button>
        <button type="button" onclick="location.href='update.jsp?pno=${pno}'">수정</button>`;
    }
}

const deletePost = async () => {
    const option = {method : "DELETE"};
    const response = await fetch(`/post?pno=${pno}`, option);
    const data = await response.json();

    if (data == true) {
        alert('삭제 성공');
        location.href = 'post.jsp?cno=1';
    } else {
        alert('삭제 실패');
    }
}

const writeReply = async () => {
    const rcontent = document.querySelector('.rcontent').value;
    const obj = {pno, rcontent};

    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch(`/post/reply`, option);
    const data = await response.json();

    if (data == 0) {
        alert('등록 실패');
    } else {
        alert('댓글 등록 성공');
        findAllReply(); // 전체 댓글 다시 불러오기
    }
}

const findAllReply = async () => {
    const response = await fetch(`/post/reply?pno=${pno}`);
    const data = await response.json();

    const replyList = document.querySelector('.replyList');
    let html = '';
    data.forEach((reply) => {
        html += `<div style="margin:20px 0px;">
                    <div>
                        작성자 : <span>${reply.mid}</span>
                        작성일 : <span>${reply.rdate}</span>
                    </div>
                    <div>
                        ${reply.rcontent}
                    </div>
                </div>`;
    })
    replyList.innerHTML = html;
}

// 최초 실행 (글, 댓글 내용 가져오기)
getPost();
findAllReply();