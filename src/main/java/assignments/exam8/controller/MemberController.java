package assignments.exam8.controller;

import assignments.exam8.model.dto.MemberDto;
import assignments.exam8.model.dto.PointDto;
import assignments.exam8.service.MemberService;
import assignments.exam8.service.PointService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private PointService pointService;

    @PostMapping("/signup")
    public int signup(@RequestBody MemberDto memberDto) {
        int mno = memberService.signup(memberDto);
        if (mno != 0) {
            PointDto pointDto = new PointDto();
            pointDto.setMno(mno);
            pointDto.setPlpoint(1000);
            pointDto.setPlcomment("회원가입");
            boolean log = pointService.log(pointDto);
            System.out.println("log = " + log);
        }
        return mno;
    }

    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpSession session) {
        int mno = memberService.login(memberDto);
        if (mno > 0) {
            session.setAttribute("loginMno", mno);
            PointDto pointDto = new PointDto();
            pointDto.setMno(mno);
            pointDto.setPlpoint(10);
            pointDto.setPlcomment("로그인");
            boolean log = pointService.log(pointDto);
            System.out.println("log = " + log);
        }
        return mno;
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            session.removeAttribute("loginMno");
        }
    }

    @GetMapping("/info")
    public MemberDto info(HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            int loginMno = (int)session.getAttribute("loginMno");
            return memberService.info(loginMno);
        }
        return null;
    }
}
