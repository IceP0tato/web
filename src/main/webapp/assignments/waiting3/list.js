const showWaiting = async () => {
    const response = await fetch("/list");
    const data = await response.json();
    
    const tbody = document.querySelector("#list");
    let html = '';
    for (let i=0; i<data.length; i++) {
        const record = data[i];
        html += `<tr>
                    <td>${record.num}</td>
                    <td>
                        <a href="/assignments/waiting3/view.jsp?num=${record.num}">
                            ${record.phone}
                        </a>
                    </td>
                    <td>${record.count}</td>
                    <td>${record.date}</td>
                </tr>`
    }
    tbody.innerHTML = html;
}
showWaiting();