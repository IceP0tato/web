package examples.d02._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// @Component : Spring 컨테이너(메모리)에 bean(객체) 등록 < 싱글톤 대신에 사용 >
// Spring Controller 는 기본적으로 HTTP(웹 서블릿) 통신을 지원함
@Controller
public class RestController {
    // REST  : CRUD 기능을 HTTP 로 제공하는 아키텍처/기술/구조
    // Spring REST
    //  Create : @PostMapping
    @PostMapping
    public void create() {
        System.out.println("RestController.create");
    }
    //  Read : @GetMapping
    @GetMapping
    public void read() {
        System.out.println("RestController.read");
    }
    //  Update : @PutMapping
    @PutMapping
    public void update() {
        System.out.println("RestController.update");
    }
    //  Delete : @DeleteMapping
    @DeleteMapping
    public void delete() {
        System.out.println("RestController.delete");
    }
}
