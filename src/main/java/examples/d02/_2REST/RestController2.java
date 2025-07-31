package examples.d02._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController2 {
    // 반환타입 있는 REST
    @GetMapping("/d02/task") // 주소 정의 가능 (http://localhost:8080/d02/task)
    @ResponseBody // 자바에서 사용하는 타입을 자동으로 http 타입으로 변환
    public int method1() {
        System.out.println("RestController2.method1");;
        return 100;
    }

    @GetMapping("/d02/task2")
    @ResponseBody
    public String method2() {
        System.out.println("RestController2.method2");
        return "스프링 메세지";
    }

    @PostMapping("/d02/task")
    @ResponseBody
    public Map<String, Integer> method3() {
        System.out.println("RestController2.method3");
        Map<String, Integer> map = new HashMap<>();
        map.put("강호동", 100);
        map.put("유재석", 95);
        return map;
    }

    @PutMapping("/d02/task")
    @ResponseBody
    public boolean method4() {
        System.out.println("RestController2.method4");
        return false;
    }

    @DeleteMapping("/d02/task")
    @ResponseBody
    public TestDto method5() {
        System.out.println("RestController2.method5");
        TestDto testDto = new TestDto();
        return testDto;
    }

    @GetMapping("/d02/task3")
    @ResponseBody
    public List<TestDto> method6() {
        System.out.println("RestController2.method6");
        ArrayList<TestDto> list = new ArrayList<>();
        list.add(new TestDto());
        list.add(new TestDto());
        return list;
    }
}
