const getMemberList = async () => {
    const tbody = document.querySelector("#tbody");
    let html = '';

    const response = await fetch("/member");
    const data = await response.json();

    for (let i=0; i<data.length; i++) {
        const obj = data[i];
        html += `<tr>
                    <td><a href='/assignments/exam1/update.jsp?custNo=${obj.custNo}'>${obj.custNo}</a></td>
                    <td>${obj.custName}</td>
                    <td>${obj.phone}</td>
                    <td>${obj.address}</td>
                    <td>${obj.joinDate}</td>
                    <td>${obj.grade=='A'?"VIP":obj.grade=='B'?"일반":"직원"}</td>
                    <td>${obj.city}</td>
                </tr>`
    }
    tbody.innerHTML = html;
}
getMemberList();