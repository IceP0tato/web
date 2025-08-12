package assignments.waiting3.model.dao;

import assignments.waiting3.model.dto.WaitingDto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao {
    public boolean addWaiting(WaitingDto dto) {
        try {
            String sql = "insert into list(phone, count) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPhone());
            ps.setInt(2, dto.getCount());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<WaitingDto> showWaiting() {
        try {
            List<WaitingDto> list = new ArrayList<>();
            String sql = "select * from list";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                WaitingDto dto = new WaitingDto();
                dto.setNum(rs.getInt("num"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                dto.setDate(rs.getString("date"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WaitingDto showWaiting(int num) {
        try {
            String sql = "select * from list where num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();

            WaitingDto dto = new WaitingDto();
            if (rs.next()) {
                dto.setNum(rs.getInt("num"));
                dto.setPhone(rs.getString("phone"));
                dto.setCount(rs.getInt("count"));
                dto.setDate(rs.getString("date"));
            }
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteWaiting(int num) {
        try {
            String sql = "delete from list where num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateWaiting(WaitingDto dto) {
        try {
            String sql = "update list set phone = ?, count = ? where num = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getPhone());
            ps.setInt(2, dto.getCount());
            ps.setInt(3, dto.getNum());
            int result = ps.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
