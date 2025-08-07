const find = async () => {
    const option = { method : "GET" };
    const response = await fetch("/student/find", option);
    const data = await response.json();
    // 동기화로 응답이 올 때까지 대기 (html에 삽입하기 위한 데이터를 먼저 받아야 함)

    const studentTbody = document.querySelector('#studentTbody');
    let html = "";
    for (let i=0; i<data.length; i++) {
        const student = data[i];
        html += `<tr>
                    <td>${student.sno}</td>
                    <td>${student.sname}</td>
                    <td>${student.skor}</td>
                    <td>${student.smath}</td>
                </tr>`
    }
    studentTbody.innerHTML = html;
}
find();
// 최초 1회 자동 실행