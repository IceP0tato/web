package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

@Repository
public class MemberDao extends Dao {
    public int signup(MemberDto memberDto) {
        try {
            String sql = "insert into member(mid, mpwd, mname, mphone) values(?, ?, ?, ?)";
            // sql + auto_increment(자동 PK) 값 반환 설정
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());
            int count = ps.executeUpdate();

            if (count == 1) {
                // auto_increment 로 자동 할당된 pk 값을 반환하여 rs 로 조작
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int mno = rs.getInt(1); // PK 값 가져오기
                    return mno; // 가입 성공한 회원의 번호 반환
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int login(MemberDto memberDto) {
        try {
            String sql = "select * from member where mid = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int mno = rs.getInt("mno");
                return mno;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public MemberDto info(int loginMno) {
        try {
            String sql = "select * from member where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                MemberDto dto = new MemberDto();
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
                dto.setMname(rs.getString("mname"));
                dto.setMphone(rs.getString("mphone"));
                dto.setMdate(rs.getString("mdate"));
                return dto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean check(String type, String data) {
        try {
            // mid, mphone 중 받은 값을 검사해야 하기에 매개변수를 대입 (띄어쓰기 주의)
            // ? = ? 같은 방식 (속성명 : ?)은 지원되지 않음
            String sql = "select * from member where "+type+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, data);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(MemberDto memberDto) {
        try {
            String sql = "update member set mname = ?, mphone = ? where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePassword(int mno, Map<String, String> map) {
        try {
            String sql = "update member set mpwd = ? where mno = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, map.get("newPwd")); // 새로운 패스워드
            ps.setInt(2, mno);
            ps.setString(3, map.get("oldPwd")); // 기준 패스워드
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int loginMno, String oldPwd) {
        try {
            String sql = "delete from member where mno = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ps.setString(2, oldPwd);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemberDto findId(String mname, String mphone) {
        try {
            String sql = "select * from member where mname = ? and mphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mname);
            ps.setString(2, mphone);
            ResultSet rs = ps.executeQuery();

            MemberDto dto = new MemberDto();
            if (rs.next()) {
                dto.setMid(rs.getString("mid"));
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemberDto findPwd(MemberDto memberDto) {
        try {
            // 난수 생성 코드
            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<6; i++) {
                int num = random.nextInt(10);
                sb.append(num);
            }
            String newPwd = sb.toString();

            String sql = "update member set mpwd = ? where mid = ? and mphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPwd);
            ps.setString(2, memberDto.getMid());
            ps.setString(3, memberDto.getMphone());
            int count = ps.executeUpdate();

            MemberDto dto = new MemberDto();
            if (count == 1) {
                sql = "select mpwd from member where mid = ? and mphone = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, memberDto.getMid());
                ps.setString(2, memberDto.getMphone());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    dto.setMpwd(rs.getString("mpwd"));
                }
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
