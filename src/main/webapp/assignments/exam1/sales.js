const getMoneyList = async () => {
    const tbody = document.querySelector("#tbody");
    let html = '';

    const response = await fetch("/money");
    const data = await response.json();

    for (let i=0; i<data.length; i++) {
        const obj = data[i];
        html += `<tr>
                    <td>${obj.custNo}</td>
                    <td>${obj.custName}</td>
                    <td>${obj.grade=='A'?"VIP":obj.grade=='B'?"일반":"직원"}</td>
                    <td>${obj.price}</td>
                </tr>`
    }
    tbody.innerHTML = html;
}
getMoneyList();