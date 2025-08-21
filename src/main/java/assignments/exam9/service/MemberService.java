package assignments.exam9.service;

import assignments.exam9.model.dao.MemberDao;
import assignments.exam9.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    // 업로드 경로 설정
    String baseDir = System.getProperty("user.dir");
    String uploadPath = baseDir + "/build/resources/main/static/upload/";

    public int signup(MemberDto memberDto) {
        return memberDao.signup(memberDto);
    }

    public boolean addImage(MemberDto memberDto, int mno) {
        // 디렉토리 생성
        File path = new File(uploadPath);
        if (!path.exists()) {
            path.mkdir();
        }

        // 파일 이름 및 경로 설정
        String uuid = UUID.randomUUID().toString();
        String mimgname;
        // 파일이 올라왔는지를 체크하여, 없으면 기본값, 있으면 파일 이름 설정
        if (memberDto.getMimg().isEmpty()) {
            mimgname = "default";
        } else {
            String fileName = uuid+"_"+memberDto.getMimg().getOriginalFilename().replaceAll("_", "-");
            mimgname = fileName;
            String filePath = uploadPath + fileName;

            // 파일 업로드
            File file = new File(filePath);
            try {
                memberDto.getMimg().transferTo(file);
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }

        // SQL 삽입
        return memberDao.addImage(mimgname, mno);
    }

    public int login(MemberDto memberDto) {
        return memberDao.login(memberDto);
    }
}
