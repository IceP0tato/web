package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.Map;

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

    public boolean check(String type, String data) {
        return memberDao.check(type, data);
    }

    public boolean update(MemberDto memberDto) {
        return memberDao.update(memberDto);
    }

    public boolean updatePassword(int mno, Map<String, String> map) {
        return memberDao.updatePassword(mno, map);
    }

    public boolean delete(int loginMno, String oldPwd) {
        return memberDao.delete(loginMno, oldPwd);
    }

    public MemberDto findId(String mname, String mphone) {
        return memberDao.findId(mname, mphone);
    }

    public MemberDto findPwd(MemberDto memberDto) {
        return memberDao.findPwd(memberDto);
    }
}
