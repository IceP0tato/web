// 비동기
const func1 = ( ) => {
    console.log("func1 [1]")
    const option = { method : "GET" }
    fetch("/d06/exam1", option)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            console.log("func1 [2]")
        })
        .catch(error => { console.log(error)})
    console.log("func1 [3]")
} // 1 -> 3 -> 2 (JS는 응답을 기다리지 않음)

// 동기
const func2 = async ( ) => {
    console.log("func2 [1]")
    const option = { method : "GET" }
    try {
        const response = await fetch("/d06/exam1", option)
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.log(error);
    }
    console.log("func2 [2]")

    console.log("func2 [3]")
} // 1 -> 2 -> 3