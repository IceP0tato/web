package assignments.exam1.service;

import assignments.exam1.model.dao.MemberDao;
import assignments.exam1.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao dao;

    public boolean postMember(MemberDto dto) {
        return dao.postMember(dto);
    }

    public List<MemberDto> getMemberList() {
        return dao.getMemberList();
    }

    public boolean putMember(MemberDto dto) {
        return dao.putMember(dto);
    }
}
