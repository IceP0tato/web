const boardPrint = async () => {
    const response = await fetch("/board");
    const data = await response.json();

    const boardTbody = document.querySelector('#boardTbody');
    let html = '';

    for (let i=0; i<data.length; i++) {
        const board = data[i];
        html += `<tr>
                    <td>${board.bno}</td>
                    <td>
                        <a href="/board/view.jsp?bno=${board.bno}">
                            ${board.bcontent}
                        </a>
                    </td>
                    <td>${board.bwriter}</td>
                </tr>`
    }
    boardTbody.innerHTML = html;
}
boardPrint();