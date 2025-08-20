const onInfo = async () => {
    try {
        const response = await fetch('/log');
        const data = await response.json();

        console.log(data);
        const tbody = document.querySelector('tbody');
        let html = '';

        for (let i=0; i<data.length; i++) {
            const obj = data[i];
            html += `<tr>
                        <td>${i+1}</td>
                        <td>${obj.plpoint}</td>
                        <td>${obj.plcomment}</td>
                        <td>${obj.pldate}</td>
                    </tr>`;
        }
        tbody.innerHTML = html;
    } catch (error) {
        console.log(error);
        location.href = "/assignments/exam8/login.jsp";
    }
}
onInfo();