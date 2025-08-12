package assignments.exam1.model.dao;

import assignments.exam1.model.dto.MemberDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDao extends Dao {
    public boolean postMember(MemberDto dto) {
        try {
            String sql = "insert into member_tbl_02 values(?, ?, ?, ?, ?, ? ,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getCustNo());
            ps.setString(2, dto.getCustName());
            ps.setString(3, dto.getPhone());
            ps.setString(4, dto.getAddress());
            ps.setString(5, dto.getJoinDate());
            ps.setString(6, dto.getGrade());
            ps.setString(7, dto.getCity());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<MemberDto> getMemberList() {
        try {
            List<MemberDto> list = new ArrayList<>();
            String sql = "select * from member_tbl_02";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MemberDto dto = new MemberDto();
                dto.setCustNo(rs.getInt("custNo"));
                dto.setCustName(rs.getString("custName"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setJoinDate(rs.getString("joinDate"));
                dto.setGrade(rs.getString("grade"));
                dto.setCity(rs.getString("city"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean putMember(MemberDto dto) {
        try {
            String sql = "update member_tbl_02 set " +
                    "custName = ?, phone = ?, address = ?, " +
                    "joinDate = ?, grade = ?, city = ? " +
                    "where custNo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getCustName());
            ps.setString(2, dto.getPhone());
            ps.setString(3, dto.getAddress());
            ps.setString(4, dto.getJoinDate());
            ps.setString(5, dto.getGrade());
            ps.setString(6, dto.getCity());
            ps.setInt(7, dto.getCustNo());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
