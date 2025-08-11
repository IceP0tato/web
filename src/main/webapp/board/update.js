const boardFind = async () => {
    const bno = new URLSearchParams(location.search).get('bno');
    
    const response = await fetch(`/board/find?bno=${bno}`);
    const data = await response.json();

    document.querySelector(".bcontent").innerHTML = data.bcontent;
}
boardFind();

const boardUpdate = async () => {
    const bno = new URLSearchParams(location.search).get('bno');
    const bcontent = document.querySelector(".bcontent").value;
    const obj = {'bno': bno, 'bcontent': bcontent};

    const option = {
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch(`/board`, option);
    const data = await response.json();

    if (data) {
        alert('수정 성공');
        location.href=`/board/view.jsp?bno=${bno}`;
    } else {
        alert('수정 실패 (관리자에게 문의)');
    }
}