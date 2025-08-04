package examples.d04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // HTTP 요청과 응답 처리
public class FetchController {
    @GetMapping("/d04/exam1")
    public void method1() {
        System.out.println("FetchController.method1");
    }

    @PostMapping("/d04/exam2")
    public void method2() {
        System.out.println("FetchController.method2");
    }

    @PutMapping("/d04/exam3")
    public void method3() {
        System.out.println("FetchController.method3");
    }

    @DeleteMapping("/d04/exam4")
    public void method4() {
        System.out.println("FetchController.method4");
    }

    @GetMapping("/d04/exam5")
    public boolean method5(@RequestParam String name, @RequestParam int age) {
        System.out.println("FetchController.method5");
        System.out.println("name = " + name + ", age = " + age);
        boolean result = true;
        System.out.println("result = " + result);
        return result;
    }

    @PostMapping("/d04/exam6")
    public int method6(@RequestBody Map<String, String> map) {
        System.out.println("FetchController.method6");
        System.out.println("map = " + map);
        int result = 20;
        return result;
    }

    @PutMapping("/d04/exam7")
    public TestDto method7(@RequestBody TestDto testDto) {
        System.out.println("FetchController.method7");
        System.out.println("testDto = " + testDto);
        TestDto result = new TestDto("강호동", 40);
        return result;
    }

    @DeleteMapping("/d04/exam8")
    public List<TestDto> method8(@RequestParam String name, int age) {
        System.out.println("FetchController.method8");
        System.out.println("name = " + name + ", age = " + age);
        List<TestDto> result = new ArrayList<>();
        result.add(new TestDto("강호동", 10));
        return result;
    }
}
