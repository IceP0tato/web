console.log("JS 실행2");
console.log(3);
console.log(3.14);
console.log(true);
console.log(null);
console.log(undefined);
console.log("안녕1");
console.log('안녕2');
console.log(`안녕3`);
console.log([3, 3.14, true, '안녕4']);
console.log(function test(){});
console.log({"속성명1" : 3, "속성명2" : "안녕5"});

let var1 = 15;
const var2 = "유재석";

function func1(a, b) {
    console.log('func1 exe');
    return a + b;
}

let result = func1(10, 20);
console.log(result);

// 익명 함수
const func2 = function(a , b) {
    console.log('func2 exe');
    return a + b;
}
func2(10, 20);

// 람다식 함수
const func3 = (a, b) => {
    console.log('func3 exe');
    return a + b;
}
func3(10, 20);