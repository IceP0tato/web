package assignments.exam8.controller;

import assignments.exam8.model.dto.PointDto;
import assignments.exam8.service.PointService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PointController {
    @Autowired
    private PointService pointService;

   @GetMapping("/log")
    public List<PointDto> logCheck(HttpSession session) {
        if (session.getAttribute("loginMno") == null) {
            return null;
        }
        int loginMno = (int)session.getAttribute("loginMno");
        return pointService.logCheck(loginMno);
    }
}
