const onInfo = async () => {
    try {
        const response = await fetch('/exam9/image/get');
        const data = await response.json();

        console.log(data);
        const img = document.querySelector('#img');
        let html = `<img src=${data.mimgname=="default"?"https://placehold.co/100x150":"/upload/"+data.mimgname} />`;
        img.innerHTML = html;
    } catch (error) {
        console.log(error);
        location.href = "/assignments/exam9/login.jsp";
    }
}
onInfo();

const change = async () => {
    const form = document.querySelector("form");
    const formData = new FormData(form);

    try {
        const option = {
            method : "POST",
            body : formData
        }
        const response = await fetch('/exam9/image/post', option);
        const data = await response.json();

        if (data > 0) {
            alert('이미지 수정 성공');
            location.href = '/assignments/exam9/index.jsp';
        } else {
            alert('이미지 수정 실패');
        }
    } catch (error) { 
        console.log(error);
    }
}