package examples.d08.MVC_2.controller;

import examples.d08.MVC_2.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller 빈 등록
public class MvcController {
    @Autowired // Service 빈 주입
    private MvcService mvcService;

    @GetMapping("/d08/mvc")
    public void method() {
        System.out.println("MvcController.method");
        mvcService.method(); // 서비스의 메소드 호출
    }
}
