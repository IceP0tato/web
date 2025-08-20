package assignments.exam8.service;

import assignments.exam8.model.dao.MemberDao;
import assignments.exam8.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public int signup(MemberDto memberDto) {
        return memberDao.signup(memberDto);
    }

    public int login(MemberDto memberDto) {
        return memberDao.login(memberDto);
    }

    public MemberDto info(int loginMno) {
        return memberDao.info(loginMno);
    }
}
