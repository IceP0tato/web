package assignments.waiting3.service;

import assignments.waiting3.model.dao.WaitingDao;
import assignments.waiting3.model.dto.WaitingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaitingService {
    @Autowired
    private WaitingDao waitingDao;

    public boolean addWaiting(WaitingDto dto) {
        return waitingDao.addWaiting(dto);
    }

    public List<WaitingDto> showWaiting() {
        return waitingDao.showWaiting();
    }

    public WaitingDto showWaiting(int num) {
        return waitingDao.showWaiting(num);
    }

    public boolean deleteWaiting(int num) {
        return waitingDao.deleteWaiting(num);
    }

    public boolean updateWaiting(WaitingDto dto) {
        return waitingDao.updateWaiting(dto);
    }
}
