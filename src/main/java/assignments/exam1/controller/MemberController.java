package assignments.exam1.controller;

import assignments.exam1.model.dto.MemberDto;
import assignments.exam1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public boolean postMember(@RequestBody MemberDto dto) {
        return memberService.postMember(dto);
    }

    @GetMapping("")
    public List<MemberDto> getMemberList() {
        return memberService.getMemberList();
    }

    @PutMapping("")
    public boolean putMember(@RequestBody MemberDto dto) {
        return memberService.putMember(dto);
    }
}
