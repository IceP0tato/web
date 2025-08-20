package assignments.exam8.model.dao;

import assignments.exam8.model.dto.PointDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PointDao extends Dao {
    public boolean log(PointDto pointDto) {
        try {
            String sql = "insert into pointlog(mno, plpoint, plcomment) values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pointDto.getMno());
            ps.setInt(2, pointDto.getPlpoint());
            ps.setString(3, pointDto.getPlcomment());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PointDto> logCheck(int loginMno) {
        try {
            String sql = "select * from pointlog where mno = ? order by pldate desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, loginMno);
            ResultSet rs = ps.executeQuery();

            List<PointDto> list = new ArrayList<>();
            while (rs.next()) {
                PointDto dto = new PointDto();
                dto.setPlno(rs.getInt("plno"));
                dto.setMno(rs.getInt("mno"));
                dto.setPlcomment(rs.getString("plcomment"));
                dto.setPldate(rs.getString("pldate"));
                dto.setPlpoint(rs.getInt("plpoint"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
