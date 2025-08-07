package assignments.waiting2.model.dao;

import assignments.waiting2.model.dto.WaitingDto;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {
    @Getter
    private static final WaitingDao instance = new WaitingDao();
    private WaitingDao() { connect(); }
    private Connection conn;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/waiting", "root", "1234");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addWaiting(WaitingDto waitingDto) {
        try {
            String sql = "insert into list(phone, count) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getCount());

            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<WaitingDto> printWaiting() {
        try {
            ArrayList<WaitingDto> list = new ArrayList<>();
            String sql = "select * from list";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                WaitingDto dto = new WaitingDto(
                        rs.getInt("num"),
                        rs.getString("phone"),
                        rs.getInt("count"),
                        rs.getString("date")
                );
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
