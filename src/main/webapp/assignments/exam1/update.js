const defaultMember = async () => {
    const num = new URLSearchParams(location.search).get('custNo');
    const custNo = document.querySelector("#custNo");
    const custName = document.querySelector("#custName");
    const phone = document.querySelector("#phone");
    const address = document.querySelector("#address");
    const joinDate = document.querySelector("#joinDate");
    const grade = document.querySelector("#grade");
    const city = document.querySelector("#city");

    const response = await fetch("/member");
    const data = await response.json();

    for (let i=0; i<data.length; i++) {
        const obj = data[i];
        if (obj.custNo == num) {
            custNo.value = obj.custNo;
            custName.value = obj.custName;
            phone.value = obj.phone;
            address.value = obj.address;
            joinDate.value = obj.joinDate;
            grade.value = obj.grade;
            city.value = obj.city;
            return;
        }
    }
}
defaultMember();

const putMember = async () => {
    // value 가져오기
    const custNo = document.querySelector("#custNo").value;
    const custName = document.querySelector("#custName").value;
    const phone = document.querySelector("#phone").value;
    const address = document.querySelector("#address").value;
    const joinDate = document.querySelector("#joinDate").value;
    const grade = document.querySelector("#grade").value;
    const city = document.querySelector("#city").value;

    // value 유효성 체크
    if (custNo == "") {
        alert("회원번호가 입력되지 않았습니다.");
        return;
    }
    if (custName == "") {
        alert("회원성명이 입력되지 않았습니다.");
        return;
    }
    if (phone == "") {
        alert("회원전화가 입력되지 않았습니다.");
        return;
    }
    if (address == "") {
        alert("회원주소가 입력되지 않았습니다.");
        return;
    }
    if (joinDate == "") {
        alert("가입일자가 입력되지 않았습니다.");
        return;
    }
    if (grade == "") {
        alert("고객등급이 입력되지 않았습니다.");
        return;
    } else if (grade != "A" && grade != "B" && grade != "C") {
        alert("유효하지 않은 고객등급입니다.");
        return;
    }
    if (city == "") {
        alert("도시코드가 입력되지 않았습니다.");
        return;
    }

    const obj = {
        "custNo": custNo,
        "custName": custName,
        "phone": phone,
        "address": address,
        "joinDate": joinDate,
        "grade": grade,
        "city": city
    }

    // 통신 처리
    const option = {
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    const response = await fetch("/member", option);
    const data = await response.json();

    if (data) {
        alert("회원정보수정이 완료 되었습니다!")
        location.href = "/assignments/exam1/members.jsp";
    } else {
        alert("회원정보수정이 완료되지 않았습니다.")
    }
}

const getMemberView = () => {
    location.href = "/assignments/exam1/members.jsp";
}