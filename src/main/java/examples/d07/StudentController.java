package examples.d07;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student") // 지정한 클래스 내 모든 메소드들의 공통 URL
public class StudentController {
    private StudentDao studentDao = StudentDao.getInstance();
    @PostMapping("/save")
    public boolean save(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.save");
        System.out.println("studentDto = " + studentDto);
        boolean result = studentDao.save(studentDto);
        return result;
    }

    @GetMapping("/find")
    public List<StudentDto> find() {
        System.out.println("StudentController.find");
        List<StudentDto> result = studentDao.find();
        return result;
    }
}
