package assignments.exam1.controller;

import assignments.exam1.model.dto.MoneyDto;
import assignments.exam1.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    @GetMapping("")
    public List<MoneyDto> getMoneyList() {
        return moneyService.getMoneyList();
    }
}
