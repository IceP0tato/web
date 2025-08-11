package examples.d08.MVC_2.service;

import examples.d08.MVC_2.model.dao.MvcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Service 빈 등록
public class MvcService {
    @Autowired // Repository(Dao) 빈 주입
    private MvcDao mvcDao;

    public void method() {
        System.out.println("MvcService.method");
        mvcDao.method();
    }
}
