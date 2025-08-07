package examples.d06;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchController {
    @GetMapping("/d06/exam1")
    public boolean method1() {
        return true;
    }
}
