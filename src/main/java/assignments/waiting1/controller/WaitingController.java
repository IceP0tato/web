package assignments.waiting1.controller;

import assignments.waiting1.model.dao.WaitingDao;
import assignments.waiting1.model.dto.WaitingDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class WaitingController {
    WaitingDao dao = WaitingDao.getInstance();

    @PostMapping("/list")
    public boolean waitingInsert(@RequestBody WaitingDto dto) {
        return dao.waitingInsert(dto);
    }

    @GetMapping("/list")
    public ArrayList<WaitingDto> waitingSelect() {
        return dao.waitingSelect();
    }

    @DeleteMapping("/list")
    public boolean waitingDelete(@RequestParam int num) {
        return dao.waitingDelete(num);
    }

    @PutMapping("/list")
    public boolean waitingUpdate(@RequestBody WaitingDto dto) {
        return dao.waitingUpdate(dto);
    }
}
