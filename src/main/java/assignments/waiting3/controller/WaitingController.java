package assignments.waiting3.controller;

import assignments.waiting3.model.dto.WaitingDto;
import assignments.waiting3.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class WaitingController {
    @Autowired
    private WaitingService waitingService;

    @PostMapping("")
    public boolean addWaiting(@RequestBody WaitingDto dto) {
        return waitingService.addWaiting(dto);
    }

    @GetMapping("")
    public List<WaitingDto> showWaiting() {
        return waitingService.showWaiting();
    }

    @GetMapping("/find")
    public WaitingDto showWaiting(@RequestParam int num) {
        return waitingService.showWaiting(num);
    }

    @DeleteMapping("")
    public boolean deleteWaiting(@RequestParam int num) {
        return waitingService.deleteWaiting(num);
    }

    @PutMapping("")
    public boolean updateWaiting(@RequestBody WaitingDto dto) {
        return waitingService.updateWaiting(dto);
    }
}
