package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public int signup(@RequestBody MemberDto memberDto) {
        int result = memberService.signup(memberDto);
        return result;
    }

    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int result = memberService.login(memberDto);
        if (result > 0) {
            session.setAttribute("loginMno", result); // 속성값은 자동 타입 변환으로 Object 타입으로 변함
        }
        return result;
    }

    // MemberDao, MemberService 에 없음 (로그인 상태는 DB와 무관)
    // 세션은 서버를 재시작하면 초기화됨
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 로그인 상태 확인
        if (session == null || session.getAttribute("loginMno") == null) {
            return false;
        }
        // 로그인 상태일 시 속성값 제거
        session.removeAttribute("loginMno");
        return true;
    }

    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return null;
        }
        // Object 타입을 int 타입으로 강제 타입 변환
        int loginMno = (int)session.getAttribute("loginMno");
        return memberService.info(loginMno);
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String type, @RequestParam String data) {
        return memberService.check(type, data);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody MemberDto memberDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return false;
        }
        // Object 타입을 int 타입으로 강제 타입 변환
        int loginMno = (int)session.getAttribute("loginMno");
        // Dto에 담아서 전달
        memberDto.setMno(loginMno);
        return memberService.update(memberDto);
    }

    // memberDto 없는 일회성 객체 이동 시 dto를 새로 만들거나 Map 컬렉션 사용
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String, String> map, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return false;
        }
        // Object 타입을 int 타입으로 강제 타입 변환
        int loginMno = (int)session.getAttribute("loginMno");
        return memberService.updatePassword(loginMno, map);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String oldPwd, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMno") == null) {
            return false;
        }
        // Object 타입을 int 타입으로 강제 타입 변환
        int loginMno = (int)session.getAttribute("loginMno");
        return memberService.delete(loginMno, oldPwd);
    }
}
