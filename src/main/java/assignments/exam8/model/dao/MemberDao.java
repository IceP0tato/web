package assignments.exam8.model.dao;

import assignments.exam8.model.dto.MemberDto;
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

    public int login(MemberDto memberDto) {
        try {
            String sql = "select * from member where mid = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int mno = rs.getInt("mno");
                int mpoint = rs.getInt("mpoint");
                // 포인트 10 증가
                sql = "update member set mpoint = ? where mid = ? and mpwd = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, mpoint+10);
                ps.setString(2, memberDto.getMid());
                ps.setString(3, memberDto.getMpwd());
                System.out.println("point +" + ps.executeUpdate()*10);
                return mno;
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MemberDto info(int loginMno) {
        try {
            String sql = "select * from member where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ResultSet rs = ps.executeQuery();

            MemberDto dto = new MemberDto();
            if (rs.next()) {
                dto.setMno(rs.getInt("mno"));
                dto.setMid(rs.getString("mid"));
                dto.setMpoint(rs.getInt("mpoint"));
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
