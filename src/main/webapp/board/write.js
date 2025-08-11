const boardWrite = async () => {
    const bcontent = document.querySelector('.bcontent').value;
    const bwriter = document.querySelector('.bwriter').value;
    const obj = {'bcontent': bcontent, 'bwriter': bwriter};

    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch("/board", option);
    const data = await response.json();

    if (data) {
        alert('글쓰기 성공');
        location.href="/board/list.jsp";
    } else {
        alert('글쓰기 실패');
    }
}