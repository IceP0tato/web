const print = async () => {
    const option = { method : "GET" };
    const response = await fetch("/waiting/get", option);
    const data = await response.json();

    const tbody = document.querySelector('#tbody');
    let html = '';
    for (let i=0; i<data.length; i++) {
        const list = data[i];
        html += `<tr>
                    <td>${list.num}</td>
                    <td>${list.phone}</td>
                    <td>${list.count}</td>
                    <td>${list.date}</td>
                </tr>`
    }
    tbody.innerHTML = html;
}
print();