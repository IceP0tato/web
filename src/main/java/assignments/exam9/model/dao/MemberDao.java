package assignments.exam9.model.dao;

import assignments.exam9.model.dto.MemberDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class MemberDao extends Dao {
    public int signup(MemberDto memberDto) {
        try {
            String sql = "insert into member(mid, mpwd) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            int count = ps.executeUpdate();

            if (count == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addImage(String mimgname, int mno) {
        try {
            String sql = "insert into memberimg(mimgname, mno) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mimgname);
            ps.setInt(2, mno);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int login(MemberDto memberDto) {
        try {
            String sql = "select * from member where mid = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemberDto info(int mno) {
        try {
            String sql = "select * from member where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ResultSet rs = ps.executeQuery();

            MemberDto dto = new MemberDto();
            if (rs.next()) {
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 최신 이미지 이름 1개 가져오기
    public MemberDto getImageName(int mno) {
        try {
            String sql = "select * from memberimg where mno = ? order by mimgno desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ResultSet rs = ps.executeQuery();

            MemberDto dto = new MemberDto();
            if (rs.next()) {
                dto.setMimgname(rs.getString("mimgname"));
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
