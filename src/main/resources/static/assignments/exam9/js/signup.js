const signup = async () => {
    const form = document.querySelector("form");
    const formData = new FormData(form);
    
    try {
        const option = {
            method : "POST",
            body : formData
        }
        const response = await fetch('/exam9/signup', option);
        const data = await response.json();

        if (data > 0) {
            alert('회원가입 성공');
            location.href = '/assignments/exam9/login.jsp';
        } else {
            alert('회원가입 실패');
        }
    } catch (error) { 
        console.log(error);
    }
}