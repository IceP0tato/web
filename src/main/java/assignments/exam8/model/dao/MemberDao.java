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
                    return rs.getInt("mno");
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
                return rs.getInt("mno");
            }
            return 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
