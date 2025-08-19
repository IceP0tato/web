package assignments.exam8.service;

import assignments.exam8.model.dao.PointDao;
import assignments.exam8.model.dto.PointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    @Autowired
    private PointDao pointDao;

    public boolean log(PointDto pointDto) {
        return pointDao.log(pointDto);
    }

    public List<PointDto> logCheck(int loginMno) {
        return pointDao.logCheck(loginMno);
    }
}
