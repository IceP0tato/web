const save = async () => {
    const snameInput = document.querySelector(".sname");
    const skorInput = document.querySelector(".skor");
    const smathInput = document.querySelector(".smath");
    const sname = snameInput.value;
    const skor = skorInput.value;
    const smath = smathInput.value;
    const object = { sname : sname, skor : skor, smath : smath };

    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(object)
    };
    const response = await fetch("/student/save", option);
    const data = await response.json();

    if (data) {
        alert('등록 성공');
        location.href="/student/find.jsp";
    } else {
        alert ('등록 실패');
    }
}