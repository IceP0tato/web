package assignments.exam1.service;

import assignments.exam1.model.dao.MoneyDao;
import assignments.exam1.model.dto.MoneyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {
    @Autowired
    private MoneyDao dao;

    public List<MoneyDto> getMoneyList() {
        return dao.getMoneyList();
    }
}
