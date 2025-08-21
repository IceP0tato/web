package assignments.exam9.controller;

import assignments.exam9.model.dto.MemberDto;
import assignments.exam9.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam9")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public int signup(@ModelAttribute MemberDto memberDto) {
        // 회원가입
        int mno = memberService.signup(memberDto);
        if (mno > 0) {
            // 회원가입 시 이미지 업로드 및 로그 기록
            memberService.addImage(memberDto, mno);
        }
        return mno;
    }

    // 로그인
    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpSession session) {
        // 로그인
        int mno = memberService.login(memberDto);
        if (mno > 0) {
            session.setAttribute("loginMno", mno);
        }
        return mno;
    }

    // 계정 정보와 이미지 가져오기
    @GetMapping("/info")
    public MemberDto info(HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            int mno = (int)session.getAttribute("loginMno");
            MemberDto dto = memberService.info(mno);
            MemberDto imageDto = memberService.getImageName(mno);
            dto.setMimgname(imageDto.getMimgname());
            return dto;
        }
        return null;
    }

    // 로그아웃
    @GetMapping("/logout")
    public void logout(HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            session.removeAttribute("loginMno");
        }
    }

    // 최신 이미지 불러오기
    @GetMapping("/image/get")
    public MemberDto getImageName(HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            int mno = (int)session.getAttribute("loginMno");
            return memberService.getImageName(mno);
        }
        return null;
    }

    // 이미지 수정
    @PostMapping("/image/post")
    public boolean postImage(@ModelAttribute MemberDto memberDto, HttpSession session) {
        if (session.getAttribute("loginMno") != null) {
            int mno = (int)session.getAttribute("loginMno");
            memberService.info(mno);
            return memberService.addImage(memberDto, mno);
        }
        return false;
    }
}
