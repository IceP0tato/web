package assignments.waiting2.controller;

import assignments.waiting2.model.dao.WaitingDao;
import assignments.waiting2.model.dto.WaitingDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    private WaitingDao dao = WaitingDao.getInstance();

    @PostMapping("/post")
    public boolean addWaiting(@RequestBody WaitingDto waitingDto) {
        return dao.addWaiting(waitingDto);
    }

    @GetMapping("/get")
    public ArrayList<WaitingDto> printWaiting() {
        return dao.printWaiting();
    }
}
