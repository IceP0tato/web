package examples.d03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // @Controller (+Component) + @ResponseBody
public class RestController1 {

    @GetMapping("/d03")
    // @ResponseBody // HTTP 요청 처리 후 자바 타입에서 HTTP 타입 (주로 JSON)으로 자동 변환 (RestController 사용 시 생략 가능)
    public String method1() {
        return "자바 메세지";
    }

    @GetMapping("/d03/param1")
    public boolean method2(@RequestParam(name="name", defaultValue="홍길동", required=true) String name) {
        // @RequestParam : 매개변수 요청 매핑
        // (name="URL매개변수명", defaultValue="기본값", required=true/false(필수))
        // param1?name=유재석 -> @RequestParam(name="name") String nickname -> nickname 매개변수를 name 으로 입력
        // param1 -> @RequestParam(defaultValue="홍길동") -> name="홍길동"
        // required : 해당 매개변수가 없으면 예외 자동 발생 (Error 400 : Bad Request)
        System.out.println("RestController1.method2"); // soutm
        System.out.println("name = " + name); // soutp
        return true;
    }

    @GetMapping("/d03/param2")
    public int method3(String name, int age) {
        System.out.println("RestController1.method3");
        System.out.println("name = " + name + ", age = " + age);
        return 3;
    }

    @DeleteMapping("/d03/param3")
    public String method4(@RequestParam Map<String, String> map) {
        // 일반적으로 정해진 규칙이나 매개변수명이 아닌 단순 MAP(비규칙) 구조일 경우 @RequestParam 필요
        System.out.println("RestController1.method4");
        System.out.println("map = " + map);
        return "Hello";
    }

    @DeleteMapping("/d03/param4")
    public int method5(@ModelAttribute TestDto testDto) {
        System.out.println("RestController1.method5");
        System.out.println("testDto = " + testDto);
        System.out.println(testDto.getName());
        System.out.println(testDto.getAge());
        return 3;
    }

    @PostMapping("/d03/param5")
    public boolean method6(@RequestBody TestDto testDto) {
        System.out.println("RestController1.method6");
        System.out.println("testDto = " + testDto);
        System.out.println(testDto.getName());
        System.out.println(testDto.getAge());
        return true;
    }

    @PutMapping("/d03/param6")
    public int method7(@RequestBody Map<String, String> map) {
        System.out.println("RestController1.method7");
        System.out.println("map = " + map);
        return 3;
    }

    // @RequestParam : DTO 내 동일한 멤버변수와 생성자가 구현된 상태일 때 자동 생성 (name과 age 멤버변수가 있어야 함)
    // 단일 파라미터에 변수 바인딩, 변수명이 일치하면 생략 가능, 기본형 (int, String, List, Map)
    // QueryString, <form> (첨부파일 X), GET/POST/PUT/DELETE

    // @ModelAttribute
    // 복수 파라미터에 객체 바인딩, DTO 타입일 때 기본 적용 (생성자, setter), 개발자가 만든 객체 (DTO, VO [읽기모드, setter 없음])
    // QueryString, <form> (첨부파일 O), GET/POST/PUT/DELETE

    // @RequestBody
    // 본문 객체 바인딩, DTO, 본문(body), POST/PUT

    // QueryString : URL 경로 상의 매개변수 표현, 노출 O (보안 위험), URL?param=value&param2=value
    // Body : HTTP 본문에 매개변수 표현, 노출 X (보안 안전), POST/PUT 에서 JSON 타입으로 객체 지원
}
